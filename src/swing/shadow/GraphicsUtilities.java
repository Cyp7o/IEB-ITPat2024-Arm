// Define the package that this class belongs to
package swing.shadow;

// Import the required classes
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Transparency;
import java.awt.GraphicsEnvironment;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

// The GraphicsUtilities class provides utility methods for handling images and graphics
public class GraphicsUtilities {

    // Private constructor to prevent instantiation
    private GraphicsUtilities() {
    }

    // Returns the graphics configuration for the primary screen
    private static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
    }

    // Creates a BufferedImage with the same color model as the input image
    public static BufferedImage createColorModelCompatibleImage(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        return new BufferedImage(cm,
                cm.createCompatibleWritableRaster(image.getWidth(), image.getHeight()),
                cm.isAlphaPremultiplied(), null);
    }

    // Creates a BufferedImage that is compatible with the graphics configuration
    // of the input image
    public static BufferedImage createCompatibleImage(BufferedImage image) {
        return createCompatibleImage(image, image.getWidth(), image.getHeight());
    }

    // Creates a BufferedImage with the specified width and height that is compatible
    // with the graphics configuration of the input image
    public static BufferedImage createCompatibleImage(BufferedImage image, int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, image.getTransparency());
    }

    // Creates a BufferedImage with the specified width and height that is compatible
    // with the graphics configuration of the primary screen
    public static BufferedImage createCompatibleImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height);
    }

    // Creates a BufferedImage with the specified width and height and a translucent
    // (transparent) image type
    public static BufferedImage createCompatibleTranslucentImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }

    // Loads an image from the provided URL and returns a BufferedImage that is
    // compatible with the graphics configuration of the primary screen
    public static BufferedImage loadCompatibleImage(URL resource) throws IOException {
        BufferedImage image = ImageIO.read(resource);
        return toCompatibleImage(image);
    }

    // Converts a given BufferedImage to a compatible BufferedImage that is
    // compatible with the graphics configuration of the primary screen
    public static BufferedImage toCompatibleImage(BufferedImage image) {
        // If the color model of the input image is already compatible with the
        // graphics configuration, simply return the input image.
        if (image.getColorModel().equals(getGraphicsConfiguration().getColorModel())) {
            return image;
        }

        // Create a new compatible image with the same dimensions and transparency as the input image
        BufferedImage compatibleImage = getGraphicsConfiguration().createCompatibleImage(
                image.getWidth(), image.getHeight(), image.getTransparency());

        // Draw the input image onto the new compatible image
        Graphics g = compatibleImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return compatibleImage;
    }

    // Creates a thumbnail of the given BufferedImage using a fast but less accurate algorithm
    // The new size of the thumbnail is specified by 'newSize'.
    public static BufferedImage createThumbnailFast(BufferedImage image, int newSize) {
        // The algorithm resizes the image while maintaining the aspect ratio.
        // It uses a fast but less accurate interpolation method (BILINEAR).
        // The new size of the thumbnail is specified by 'newSize'.

        // Calculate the new width and height of the thumbnail while maintaining aspect ratio
        float ratio;
        int width = image.getWidth();
        int height = image.getHeight();

        if (width > height) {
            if (newSize >= width) {
                throw new IllegalArgumentException("newSize must be lower than the image width");
            } else if (newSize <= 0) {
                throw new IllegalArgumentException("newSize must be greater than 0");
            }

            ratio = (float) width / (float) height;
            width = newSize;
            height = (int) (newSize / ratio);
        } else {
            if (newSize >= height) {
                throw new IllegalArgumentException("newSize must be lower than the image height");
            } else if (newSize <= 0) {
                throw new IllegalArgumentException("newSize must be greater than 0");
            }

            ratio = (float) height / (float) width;
            height = newSize;
            width = (int) (newSize / ratio);
        }

        // Create a new compatible image with the calculated width and height
        BufferedImage temp = createCompatibleImage(image, width, height);

        // Resize the original image to the new size using BILINEAR interpolation
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }

    // Creates a thumbnail of the given BufferedImage using a fast but less accurate algorithm
    // The new size of the thumbnail is specified by 'newWidth' and 'newHeight'.
    public static BufferedImage createThumbnailFast(BufferedImage image, int newWidth, int newHeight) {
        // The algorithm resizes the image while maintaining the aspect ratio.
        // It uses a fast but less accurate interpolation method (BILINEAR).
        // The new size of the thumbnail is specified by 'newWidth' and 'newHeight'.

        if (newWidth >= image.getWidth() || newHeight >= image.getHeight()) {
            throw new IllegalArgumentException("newWidth and newHeight cannot be greater than the image dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must be greater than 0");
        }

        // Create a new compatible image with the specified width and height
        BufferedImage temp = createCompatibleImage(image, newWidth, newHeight);

        // Resize the original image to the new size using BILINEAR interpolation
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }

    // Creates a thumbnail of the given BufferedImage using a more accurate algorithm
    // The new size of the thumbnail is specified by 'newSize'.
    public static BufferedImage createThumbnail(BufferedImage image, int newSize) {
        // The algorithm resizes the image while maintaining the aspect ratio.
        // It uses a more accurate interpolation method (BILINEAR) than the fast method.
        // The new size of the thumbnail is specified by 'newSize'.

        int width = image.getWidth();
        int height = image.getHeight();
        boolean isWidthGreater = width > height;

        if (isWidthGreater) {
            if (newSize >= width) {
                throw new IllegalArgumentException("newSize must be lower than the image width");
            }
        } else if (newSize >= height) {
            throw new IllegalArgumentException("newSize must be lower than the image height");
        }

        if (newSize <= 0) {
            throw new IllegalArgumentException("newSize must be greater than 0");
        }

        // Calculate the aspect ratio of the image
        float ratioWH = (float) width / (float) height;
        float ratioHW = (float) height / (float) width;

        BufferedImage thumb = image;

        // Resize the image iteratively to the new size using BILINEAR interpolation
        do {
            if (isWidthGreater) {
                width /= 2;
                if (width < newSize) {
                    width = newSize;
                }
                height = (int) (width / ratioWH);
            } else {
                height /= 2;
                if (height < newSize) {
                    height = newSize;
                }
                width = (int) (height / ratioHW);
            }

            // Create a new compatible image with the calculated width and height
            BufferedImage temp = createCompatibleImage(image, width, height);

            // Resize the original image to the new size using BILINEAR interpolation
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            thumb = temp;
        } while (newSize != (isWidthGreater ? width : height));

        return thumb;
    }

    // Creates a thumbnail of the given BufferedImage using a more accurate algorithm
    // The new size of the thumbnail is specified by 'newWidth' and 'newHeight'.
    public static BufferedImage createThumbnail(BufferedImage image, int newWidth, int newHeight) {
        // The algorithm resizes the image while maintaining the aspect ratio.
        // It uses a more accurate interpolation method (BILINEAR) than the fast method.
        // The new size of the thumbnail is specified by 'newWidth' and 'newHeight'.

        int width = image.getWidth();
        int height = image.getHeight();

        if (newWidth >= width || newHeight >= height) {
            throw new IllegalArgumentException("newWidth and newHeight cannot be greater than the image dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must be greater than 0");
        }

        BufferedImage thumb = image;

        // Resize the image iteratively to the new size using BILINEAR interpolation
        do {
            if (width > newWidth) {
                width /= 2;
                if (width < newWidth) {
                    width = newWidth;
                }
            }

            if (height > newHeight) {
                height /= 2;
                if (height < newHeight) {
                    height = newHeight;
                }
            }

            // Create a new compatible image with the calculated width and height
            BufferedImage temp = createCompatibleImage(image, width, height);

            // Resize the original image to the new size using BILINEAR interpolation
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            thumb = temp;
        } while (width != newWidth || height != newHeight);

        return thumb;
    }

    // Copies pixel data from the input BufferedImage to the specified array 'pixels'
    public static int[] getPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) {
        if (w == 0 || h == 0) {
            return new int[0];
        }

        if (pixels == null) {
            pixels = new int[w * h];
        } else if (pixels.length < w * h) {
            throw new IllegalArgumentException("pixels array must have a length >= w*h");
        }

        int imageType = img.getType();
        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB) {
            Raster raster = img.getRaster();
            return (int[]) raster.getDataElements(x, y, w, h, pixels);
        }

        // Unmanages the image (gets the RGB values of the specified area)
        return img.getRGB(x, y, w, h, pixels, 0, w);
    }

    // Sets pixel data in the input BufferedImage from the specified array 'pixels'
    public static void setPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) {
        if (pixels == null || w == 0 || h == 0) {
            return;
        } else if (pixels.length < w * h) {
            throw new IllegalArgumentException("pixels array must have a length >= w*h");
        }

        int imageType = img.getType();
        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB) {
            WritableRaster raster = img.getRaster();
            raster.setDataElements(x, y, w, h, pixels);
        } else {
            // Unmanages the image (sets the RGB values for the specified area)
            img.setRGB(x, y, w, h, pixels, 0, w);
        }
    }
}
