package swingExtra; // Package name where the class is located

import java.awt.Color; // For handling color
import java.awt.Graphics; // For basic drawing operations
import java.awt.Graphics2D; // For more advanced 2D graphics operations
import java.awt.RenderingHints; // For setting rendering quality hints
import javax.swing.JPanel; // For creating custom Swing panels

public class PanelBorder extends JPanel {

    // Constructor for PanelBorder
    public PanelBorder() {
        // Set the panel to be non-opaque to allow custom drawing
        setOpaque(false);
        // Set the background color of the panel
        setBackground(new Color(242, 246, 253)); // Light blue color
    }

    // Override the paintComponent method to perform custom painting
    @Override
    protected void paintComponent(Graphics grphcs) {
        // Cast Graphics object to Graphics2D for advanced drawing
        Graphics2D g2 = (Graphics2D) grphcs;
        
        // Enable anti-aliasing for smoother graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set the color for the background
        g2.setColor(getBackground());
        
        // Draw a rounded rectangle covering the entire panel
        // Parameters: x, y, width, height, arc width, arc height
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        // Call the superclass method to ensure any other painting occurs
        super.paintComponent(grphcs);
    }
}

