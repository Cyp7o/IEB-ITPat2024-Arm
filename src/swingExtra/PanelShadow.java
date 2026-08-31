package swingExtra; // Package name where the class is located

import swing.shadow.ShadowBorder; // Import the ShadowBorder class for shadow effects
import java.awt.Color; // Import Color class for handling colors
import java.awt.Graphics; // Import Graphics class for basic drawing operations
import java.awt.image.BufferedImage; // Import BufferedImage class for handling images
import javax.swing.border.EmptyBorder; // Import EmptyBorder class for creating empty borders

public class PanelShadow extends javax.swing.JPanel {

    // Get the current shadow type
    public ShadowBorder.ShadowType getShadowType() {
        return shadowType;
    }

    // Set the shadow type
    public void setShadowType(ShadowBorder.ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    // Get the current radius of the shadow
    public int getRadius() {
        return radius;
    }

    // Set the radius of the shadow
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Get the current size of the shadow
    public int getShadowSize() {
        return shadowSize;
    }

    // Set the size of the shadow and update the border accordingly
    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    // Shadow type (default: OUT_SHADOW)
    private ShadowBorder.ShadowType shadowType = ShadowBorder.ShadowType.OUT_SHADOW;
    // Radius of the shadow (default: 20)
    private int radius = 20;
    // Size of the shadow (default: 8)
    private int shadowSize = 8;
    // BufferedImage to hold the shadow image
    private BufferedImage imageShadow;

    // Constructor to initialize the panel
    public PanelShadow() {
        // Set the background color of the panel
        setBackground(new Color(242, 246, 253)); // Light blue color
        // Set the initial border size
        setBorder(new EmptyBorder(16, 16, 16, 16));
        // Make the panel non-opaque to allow custom painting
        setOpaque(false);
    }

    // Override the paintComponent method to draw the shadow image
    @Override
    protected void paintComponent(Graphics grphcs) {
        // Call the superclass method to ensure proper painting
        super.paintComponent(grphcs);
        // If a shadow image exists, draw it
        if (imageShadow != null) {
            grphcs.drawImage(imageShadow, 0, 0, null);
        }
    }

    // Override the setBounds method to update the shadow image when panel size changes
    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        // Call the superclass method to set bounds
        super.setBounds(i, i1, i2, i3);
        // Create or update the shadow image
        createShadowImage();
    }

    // Create or update the shadow image based on the shadow type
    private void createShadowImage() {
        // Use the ShadowBorder instance to create an appropriate shadow image
        if (shadowType == ShadowBorder.ShadowType.OUT_SHADOW) {
            imageShadow = ShadowBorder.getInstance().createShadowOut(this, shadowSize, radius);
        } else {
            imageShadow = ShadowBorder.getInstance().createShadowIn(this, shadowSize, radius);
        }
    }
}
