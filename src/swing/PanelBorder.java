package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelBorder extends JPanel {

    // Constructor: initializes the panel with specific properties
    public PanelBorder() {
        setOpaque(false); // Make the panel transparent so that background color can be seen
        setBackground(new Color(242, 246, 253)); // Set a light background color for the panel
    }

    // Overridden method to perform custom painting on the panel
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); // Call the superclass method to ensure proper painting

        // Cast Graphics object to Graphics2D for advanced graphics operations
        Graphics2D g2 = (Graphics2D) grphcs;
        
        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set the color for drawing the rounded rectangle
        g2.setColor(getBackground());
        
        // Draw a rounded rectangle covering the entire panel
        // Parameters: x, y, width, height, arcWidth, arcHeight
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
    }
}
