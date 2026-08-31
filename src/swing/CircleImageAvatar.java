package swing; // Defines the package for the class

import java.awt.AlphaComposite; // Import for AlphaComposite class
import java.awt.Composite; // Import for Composite class
import java.awt.Dimension; // Import for Dimension class
import java.awt.Graphics; // Import for Graphics class
import java.awt.Graphics2D; // Import for Graphics2D class
import java.awt.Image; // Import for Image class
import java.awt.Point; // Import for Point class
import java.awt.Rectangle; // Import for Rectangle class
import java.awt.RenderingHints; // Import for RenderingHints class
import java.awt.image.BufferedImage; // Import for BufferedImage class
import javax.swing.Icon; // Import for Icon class
import javax.swing.ImageIcon; // Import for ImageIcon class
import javax.swing.JComponent; // Import for JComponent class

public class CircleImageAvatar extends JComponent { // Class definition for ImageAvatar, extends JComponent

    private Icon icon; // The icon to be displayed
    private int borderSize; // The size of the border around the icon

    public Icon getIcon() { // Getter method for retrieving the current icon
        return icon;
    }

    public void setIcon(Icon icon) { // Setter method for setting the icon
        this.icon = icon;
        repaint(); // Trigger a repaint of the component
    }

    public int getBorderSize() { // Getter method for retrieving the current border size
        return borderSize;
    }

    public void setBorderSize(int borderSize) { // Setter method for setting the border size
        this.borderSize = borderSize;
    }

    @Override
    protected void paintComponent(Graphics grphcs) { // Override the paintComponent method
        if (icon != null) { // Check if an icon is set
            int width = getWidth(); // Get the width of the component
            int height = getHeight(); // Get the height of the component
            int diameter = Math.min(width, height); // Calculate the diameter as the minimum value between width and height
            int x = width / 2 - diameter / 2; // Calculate the x-coordinate for centering the image
            int y = height / 2 - diameter / 2; // Calculate the y-coordinate for centering the image
            int border = borderSize * 2; // Calculate the border size
            diameter -= border; // Adjust the diameter by subtracting the border size

            Rectangle size = getAutoSize(icon, diameter); // Get the size of the scaled icon

            BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB); // Create a buffered image for drawing the icon
            Graphics2D g2_img = img.createGraphics(); // Get the graphics context of the buffered image
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Set rendering hints for antialiasing
            g2_img.fillOval(0, 0, diameter, diameter); // Fill an oval shape in the buffered image (used for clipping)
            Composite composite = g2_img.getComposite(); // Get the current composite
            g2_img.setComposite(AlphaComposite.SrcIn); // Set the composite to draw only the source pixels
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // Set the interpolation hint for image scaling
            g2_img.drawImage(toImage(icon), size.x, size.y, size.width, size.height, null); // Draw the scaled icon onto the buffered image
            g2_img.setComposite(composite); // Restore the original composite
            g2_img.dispose(); // Dispose the graphics context of the buffered image

            Graphics2D g2 = (Graphics2D) grphcs; // Get the graphics context of the component
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Set rendering hints for antialiasing

            if (borderSize > 0) {
                diameter += border; // Increase the diameter by the border size
                g2.setColor(getForeground()); // Set the color for drawing the border
                g2.fillOval(x, y, diameter, diameter); // Fill an oval shape as the border
            }

            if (isOpaque()) {
                g2.setColor(getBackground()); // Set the color for filling the background
                diameter -= border; // Decrease the diameter by the border size
                g2.fillOval(x + borderSize, y + borderSize, diameter, diameter); // Fill an oval shape as the background
            }

            g2.drawImage(img, x + borderSize, y + borderSize, null); // Draw the buffered image onto the component
        }

        super.paintComponent(grphcs); // Call the paintComponent method of the superclass
    }

    private Rectangle getAutoSize(Icon image, int size) { // Method for calculating the size and position of the scaled icon
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw; // Calculate the scaling factor for the width
        double yScale = (double) h / ih; // Calculate the scaling factor for the height
        double scale = Math.max(xScale, yScale); // Choose the larger scaling factor
        int width = (int) (scale * iw); // Scale the width of the icon
        int height = (int) (scale * ih); // Scale the height of the icon

        if (width < 1) {
            width = 1; // Ensure the width is at least 1 pixel
        }

        if (height < 1) {
            height = 1; // Ensure the height is at least 1 pixel
        }

        int cw = size;
        int ch = size;
        int x = (cw - width) / 2; // Calculate the x-coordinate for centering the scaled icon
        int y = (ch - height) / 2; // Calculate the y-coordinate for centering the scaled icon

        return new Rectangle(new Point(x, y), new Dimension(width, height)); // Return the size as a Rectangle
    }

    private Image toImage(Icon icon) { // Method for converting the Icon to an Image
        return ((ImageIcon) icon).getImage();
    }
}
