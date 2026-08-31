package swing.shadow;

import java.awt.AlphaComposite; // For compositing and transparency effects
import java.awt.Color; // For color definitions
import java.awt.Component; // For getting component dimensions and background color
import java.awt.Graphics2D; // For advanced 2D graphics operations
import java.awt.Rectangle; // For defining rectangular areas
import java.awt.RenderingHints; // For setting rendering quality hints
import java.awt.Shape; // For defining geometric shapes
import java.awt.geom.Area; // For complex shape operations
import java.awt.geom.Path2D; // For creating custom shapes
import java.awt.geom.RoundRectangle2D; // For creating rounded rectangles
import java.awt.image.BufferedImage; // For handling images with alpha transparency

public class ShadowBorder {

    // Singleton instance of ShadowBorder
    private static ShadowBorder instance;

    // Private constructor for Singleton pattern
    private ShadowBorder() {
    }

    // Method to get the singleton instance of ShadowBorder
    public static ShadowBorder getInstance() {
        if (instance == null) {
            instance = new ShadowBorder();
        }
        return instance;
    }

    // Creates an inner shadow for a component with specified border and radius
    public BufferedImage createShadowIn(Component com, int border, int radius) {
        // Uses component dimensions and background color to create shadow
        return createShadowIn(com.getWidth(), com.getHeight(), border, radius, com.getBackground());
    }

    // Defines a custom shape for shadow effects
    private Shape splite(int width, int height) {
        Path2D.Float p = new Path2D.Float();
        p.moveTo(width, 0); // Move to top-right corner
        p.lineTo(width, height); // Draw line to bottom-right corner
        p.lineTo(0, height); // Draw line to bottom-left corner
        return p; // Return the custom shape
    }

    // Creates an outer shadow for a component with specified border and radius
    public BufferedImage createShadowOut(Component com, int border, int radius) {
        // Uses component dimensions and background color to create shadow
        return createShadowOut(com.getWidth(), com.getHeight(), border, radius, com.getBackground());
    }

    // Creates an inner shadow effect on an image with specified dimensions, border, and radius
    public BufferedImage createShadowIn(int width, int height, int border, int radius, Color color) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Initialize variables for shadow and border
        int x = border; // Horizontal offset for shadow
        int y = border; // Vertical offset for shadow
        int size = radius; // Radius for rounded corners

        // Fill the rounded rectangle with the component's background color
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, border, border);

        // Create the shadow shape and apply the shadow effect
        Shape s = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area = new Area(new Rectangle(0, 0, width - border, height - border));
        area.subtract(new Area(s)); // Subtract the rounded rectangle from the area
        area.subtract(new Area(splite(width, height))); // Subtract the custom shape
        g2.drawImage(new ShadowRenderer(border, 0.4f, new Color(89, 69, 137)).createShadow(createImage(width, height, area)), -border, -border, null);

        // Add a white highlight effect
        Shape s_w = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area_w = new Area(new Rectangle(0, 0, width, height));
        area_w.subtract(new Area(s_w)); // Subtract the rounded rectangle for highlight
        area_w.intersect(new Area(splite(width, height))); // Intersect with the custom shape
        g2.drawImage(new ShadowRenderer(border, 1f, new Color(255, 255, 255)).createShadow(createImage(width, height, area_w)), -border, -border, null);

        // Fill areas with shadows and highlights
        g2.fill(area);
        g2.fill(area_w);

        // Clear out the rounded corner areas
        g2.setComposite(AlphaComposite.Clear);
        Shape cut = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area bg = new Area(new Rectangle(0, 0, width, height));
        bg.subtract(new Area(cut)); // Subtract the rounded corner area
        g2.fill(bg);

        g2.dispose(); // Dispose of the graphics context
        return img; // Return the resulting image with shadow
    }

    // Creates an outer shadow effect on an image with specified dimensions, border, and radius
    public BufferedImage createShadowOut(int width, int height, int border, int radius, Color color) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 0;
        int y = 0;
        int size = radius;

        // Draw outer shadows
        g2.drawImage(new ShadowRenderer(border, 1f, new Color(255, 255, 255)).createShadow(createImage(x, y, width - border * 2, height - border * 2, size)), 0, 0, null);
        g2.drawImage(new ShadowRenderer(border, 0.4f, new Color(89, 69, 137)).createShadow(createImage(x, y, width - border * 3, height - border * 3, size)), border, border, null);

        // Fill the rounded rectangle with the component's background color
        g2.setColor(color);
        g2.fillRoundRect(x + border, y + border, width - border * 2, height - border * 2, size, size);

        g2.dispose(); // Dispose of the graphics context
        return img; // Return the resulting image with shadow
    }

    // Creates an image with a specified shape and area
    private BufferedImage createImage(int width, int height, Area area) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(area); // Fill the area with the specified shape
        return img; // Return the created image
    }

    // Creates an image with a rounded rectangle shape
    private BufferedImage createImage(int x, int y, int width, int height, int size) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(x, y, width, height, size, size); // Fill the rounded rectangle
        return img; // Return the created image
    }

    // Enum for shadow types
    public static enum ShadowType {
        IN_SHADOW, // Inner shadow type
        OUT_SHADOW // Outer shadow type
    }
}
