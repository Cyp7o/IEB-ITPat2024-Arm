// Define the package that this class belongs to
package swing.shadow;

// Import the required classes
import java.awt.Color;
import java.awt.image.BufferedImage;

// The ShadowRenderer class is responsible for generating shadow effects for images
public class ShadowRenderer {

    // size of the shadow in pixels (defines the fuzziness)
    private int size = 5;

    // opacity of the shadow
    private float opacity = 0.5f;

    // color of the shadow
    private Color color = Color.BLACK;

    // Default constructor for the ShadowRenderer class
    public ShadowRenderer() {
        // Call the parameterized constructor with default values
        this(5, 0.5f, Color.BLACK);
    }

    // Constructor with custom size, opacity, and color for the ShadowRenderer class
    public ShadowRenderer(final int size, final float opacity, final Color color) {
        // Set the shadow properties based on the provided parameters
        this.size = size;
        this.opacity = opacity;
        this.color = color;
    }

    // Get the color of the shadow
    public Color getColor() {
        return color;
    }

    // Get the opacity of the shadow
    public float getOpacity() {
        return opacity;
    }

    // Get the size of the shadow in pixels
    public int getSize() {
        return size;
    }

    // Method to create a shadow effect for a given BufferedImage
    public BufferedImage createShadow(final BufferedImage image) {
        // The shadow is created using a box blur algorithm to simulate the fuzzy effect.
        // The size, opacity, and color of the shadow are determined by the class variables.
        // The algorithm loops through the pixels of the source image and applies the blur
        // based on the shadow size and opacity to create the final shadow effect.
        // The result is a new BufferedImage containing the shadow effect.
        // Note: This code is credited to Sebastien Petrucci.

        // Calculate the size of the shadow (fuzziness) in both width and height
        int shadowSize = size * 2;

        // Calculate the dimensions of the destination image (original image size + shadow size)
        int srcWidth = image.getWidth();
        int srcHeight = image.getHeight();
        int dstWidth = srcWidth + shadowSize;
        int dstHeight = srcHeight + shadowSize;

        // Calculate the offset values for left and right (used in the blur algorithm)
        int left = size;
        int right = shadowSize - left;

        // Calculate the y-coordinate where the vertical blur stops
        int yStop = dstHeight - right;

        // Get the RGB value of the shadow color, ignoring the alpha component
        int shadowRgb = color.getRGB() & 0x00FFFFFF;

        // Create an array to store the alpha values of the last 'size' pixels for each row
        int[] aHistory = new int[shadowSize];
        int historyIdx;

        int aSum;

        // Create the destination image with transparent background
        BufferedImage dst = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_ARGB);

        // Create arrays to hold the pixel data of the source and destination images
        int[] dstBuffer = new int[dstWidth * dstHeight];
        int[] srcBuffer = new int[srcWidth * srcHeight];

        // Extract the pixel data of the source image
        GraphicsUtilities.getPixels(image, 0, 0, srcWidth, srcHeight, srcBuffer);

        // Calculate the offset for the last pixel in each row (used in the vertical blur)
        int lastPixelOffset = right * dstWidth;

        // Calculate the sum dividers for horizontal and vertical passes
        float hSumDivider = 1.0f / shadowSize;
        float vSumDivider = opacity / shadowSize;

        // Create lookup tables for horizontal and vertical blur averages
        int[] hSumLookup = new int[256 * shadowSize];
        for (int i = 0; i < hSumLookup.length; i++) {
            hSumLookup[i] = (int) (i * hSumDivider);
        }

        int[] vSumLookup = new int[256 * shadowSize];
        for (int i = 0; i < vSumLookup.length; i++) {
            vSumLookup[i] = (int) (i * vSumDivider);
        }

        int srcOffset;

        // Horizontal pass: extract the alpha mask from the source picture and
        // blur it into the destination picture
        for (int srcY = 0, dstOffset = left * dstWidth; srcY < srcHeight; srcY++) {

            // First pixels are empty (no blur required)
            for (historyIdx = 0; historyIdx < shadowSize;) {
                aHistory[historyIdx++] = 0;
            }

            aSum = 0;
            historyIdx = 0;
            srcOffset = srcY * srcWidth;

            // Compute the blur average with pixels from the source image
            for (int srcX = 0; srcX < srcWidth; srcX++) {

                // Extract the alpha value of the current pixel
                int a = hSumLookup[aSum];
                dstBuffer[dstOffset++] = a << 24;   // Store the alpha value only (ignore other color components)

                // The shadow color will be added in the next pass
                aSum -= aHistory[historyIdx]; // Subtract the oldest pixel from the sum

                // Extract the new pixel's alpha value and store it into history
                a = srcBuffer[srcOffset + srcX] >>> 24;
                aHistory[historyIdx] = a;

                // Add the new pixel's alpha value to the sum
                aSum += a;

                // Update the history index, ensuring it wraps around if necessary
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }

            // Blur the end of the row - no new pixels to grab
            for (int i = 0; i < shadowSize; i++) {

                // Calculate the blur average
                int a = hSumLookup[aSum];
                dstBuffer[dstOffset++] = a << 24;

                // Subtract the oldest pixel from the sum (and nothing new to add)
                aSum -= aHistory[historyIdx];

                // Update the history index, ensuring it wraps around if necessary
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }

        // Vertical pass
        for (int x = 0, bufferOffset = 0; x < dstWidth; x++, bufferOffset = x) {

            aSum = 0;

            // First pixels are empty (no blur required)
            for (historyIdx = 0; historyIdx < left;) {
                aHistory[historyIdx++] = 0;
            }

            // The next pixels come from the dstBuffer (result of the horizontal pass)
            for (int y = 0; y < right; y++, bufferOffset += dstWidth) {
                int a = dstBuffer[bufferOffset] >>> 24; // Extract alpha
                aHistory[historyIdx++] = a; // Store into history
                aSum += a; // Add to sum
            }

            bufferOffset = x;
            historyIdx = 0;

            // Compute the blur average with pixels from the previous pass
            for (int y = 0; y < yStop; y++, bufferOffset += dstWidth) {

                // Calculate the blur average
                int a = vSumLookup[aSum];
                dstBuffer[bufferOffset] = a << 24 | shadowRgb; // Store alpha value + shadow color

                // Subtract the oldest pixel from the sum
                aSum -= aHistory[historyIdx];

                // Extract the new pixel's alpha value and store it into history
                a = dstBuffer[bufferOffset + lastPixelOffset] >>> 24;
                aHistory[historyIdx] = a;

                // Add the new pixel's alpha value to the sum
                aSum += a;

                // Update the history index, ensuring it wraps around if necessary
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }

            // Blur the end of the column - no pixels to grab anymore
            for (int y = yStop; y < dstHeight; y++, bufferOffset += dstWidth) {

                // Calculate the blur average
                int a = vSumLookup[aSum];
                dstBuffer[bufferOffset] = a << 24 | shadowRgb;

                // Subtract the oldest pixel from the sum
                aSum -= aHistory[historyIdx];

                // Update the history index, ensuring it wraps around if necessary
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }

        // Set the pixels of the destination image to the buffered pixel data
        GraphicsUtilities.setPixels(dst, 0, 0, dstWidth, dstHeight, dstBuffer);

        // Return the BufferedImage with the shadow effect
        return dst;
    }
}
