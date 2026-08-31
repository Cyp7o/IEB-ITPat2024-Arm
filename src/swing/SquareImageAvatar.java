package swing; // Package declaration for the "swing" package

import java.awt.Dimension; // Import for Dimension class
import java.awt.Graphics; // Import for Graphics class
import java.awt.Graphics2D; // Import for Graphics2D class
import java.awt.Image; // Import for Image class
import java.awt.Point; // Import for Point class
import java.awt.Rectangle; // Import for Rectangle class
import java.awt.RenderingHints; // Import for RenderingHints class
import java.awt.image.BufferedImage; // Import for BufferedImage class
import javax.swing.Icon; // Import for Icon interface
import javax.swing.ImageIcon; // Import for ImageIcon class
import javax.swing.JComponent; // Import for JComponent class

public class SquareImageAvatar extends JComponent { // Class declaration for SquareImageAvatar, extending JComponent

    private Icon icon; // The icon to be displayed
    private int borderSize; // The size of the border around the icon

    public Icon getIcon() { // Method to get the icon
        return icon; // Return the icon 
    }

    public void setIcon(Icon icon) { // Method to set the icon
        this.icon = icon; // Set the icon
        repaint(); // Trigger a repaint of the component
    }

    public int getBorderSize() { // Method to get the border size
        return borderSize; // Return the border size
    }

    public void setBorderSize(int borderSize) { // Method to set the border size
        this.borderSize = borderSize; // Set the border size
    }

    @Override
    protected void paintComponent(Graphics grphcs) { // Override the paintComponent method
        if (icon != null) { // Check if the icon is not null
            int width = getWidth(); // Get the width of the component
            int height = getHeight(); // Get the height of the component
            int border = borderSize * 2; // Calculate the border size
            int contentWidth = width - border; // Calculate the content width
            int contentHeight = height - border; // Calculate the content height

            int scaledWidth = Math.min(icon.getIconWidth(), contentWidth); // Calculate the scaled width
            int scaledHeight = Math.min(icon.getIconHeight(), contentHeight); // Calculate the scaled height
            int x = (contentWidth - scaledWidth) / 2 + border / 2; // Calculate the x-coordinate for centering the scaled icon
            int y = (contentHeight - scaledHeight) / 2 + border / 2; // Calculate the y-coordinate for centering the scaled icon

            BufferedImage img = new BufferedImage(contentWidth, contentHeight, BufferedImage.TYPE_INT_ARGB); // Create a new buffered image
            Graphics2D g2_img = img.createGraphics(); // Create Graphics2D object for the buffered image
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Set rendering hint for antialiasing

            g2_img.drawImage(toImage(icon), x, y, scaledWidth, scaledHeight, null); // Draw the scaled icon onto the buffered image
            g2_img.dispose(); // Dispose the Graphics2D object

            Graphics2D g2 = (Graphics2D) grphcs; // Cast the Graphics

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Set rendering hint for antialiasing

            if (borderSize > 0) { // Draw the border
                g2.setColor(getForeground()); // Set the color for the border
                g2.fillRect(0, 0, width, height); // Draw the border rectangle
            }

            if (isOpaque()) { // Draw the background
                g2.setColor(getBackground()); // Set the color for the background
                g2.fillRect(borderSize, borderSize, contentWidth, contentHeight); // Draw the background rectangle
            }

            g2.drawImage(img, borderSize, borderSize, null); // Draw the buffered image onto the component
        }
        super.paintComponent(grphcs); // Call the superclass's paintComponent method
    }

    private Rectangle getAutoSize(Icon image, int size) { // Method to get the auto-sized rectangle for the icon
        int w = size; // Set the width of the rectangle
        int h = size; // Set the height of the rectangle
        int iw = image.getIconWidth(); // Get the width of the icon
        int ih = image.getIconHeight(); // Get the height of the icon
        double xScale = (double) w / iw; // Calculate the scaling factor for the width
        double yScale = (double) h / ih; // Calculate the scaling factor for the height
        double scale = Math.max(xScale, yScale); // Choose the larger scaling factor
        int width = (int) (scale * iw); // Scale the width of the icon
        int height = (int) (scale * ih); // Scale the height of the icon
        if (width < 1) { // Ensure the width is at least 1 pixel
            width = 1;
        }
        if (height < 1) { // Ensure the height is at least 1 pixel
            height = 1;
        }
        int cw = size; // Set the width of the container
        int ch = size; // Set the height of the container
        int x = (cw - width) / 2; // Calculate the x-coordinate for centering the scaled icon
        int y = (ch - height) / 2; // Calculate the y-coordinate for centering the scaled icon
        return new Rectangle(new Point(x, y), new Dimension(width, height)); // Return the size as a Rectangle
    }

    private Image toImage(Icon icon) { // Method to convert Icon to Image
        return ((ImageIcon) icon).getImage(); // Convert the Icon to an Image
    }
}
