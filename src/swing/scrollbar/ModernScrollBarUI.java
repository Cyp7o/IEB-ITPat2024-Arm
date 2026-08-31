package swing.scrollbar;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {

    // Constant representing the size of the thumb in pixels
    private final int THUMB_SIZE = 150;

    // Method to get the maximum size of the thumb
    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE); // Passing Dimension(0, THUMB_SIZE) if vertical
        } else {
            return new Dimension(THUMB_SIZE, 0); // Passing Dimension(THUMB_SIZE, 0) if horizontal
        }
    }

    // Method to get the minimum size of the thumb
    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE); // Passing Dimension(0, THUMB_SIZE) if vertical
        } else {
            return new Dimension(THUMB_SIZE, 0); // Passing Dimension(THUMB_SIZE, 0) if horizontal
        }
    }

    // Method to create a custom increase button for the scrollbar
    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }

    // Method to create a custom decrease button for the scrollbar
    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }

    // Method to paint the track of the scrollbar (Not implemented here, left empty)
    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // No implementation provided in this class
    }

    // Method to paint the thumb of the scrollbar
    @Override
    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // Casting Graphics object to Graphics2D to enable antialiasing
        Graphics2D g2 = (Graphics2D) grphcs;
        // Setting rendering hints to enable antialiasing for smooth graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Extracting the coordinates and dimensions of the thumb rectangle
        int x = rctngl.x;
        int y = rctngl.y;
        int width = rctngl.width;
        int height = rctngl.height;

        // Adjusting the position and size of the thumb based on the scrollbar's orientation
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8; // Moving the thumb down by 8 pixels
            height -= 16; // Decreasing the height of the thumb by 16 pixels
        } else {
            x += 8; // Moving the thumb right by 8 pixels
            width -= 16; // Decreasing the width of the thumb by 16 pixels
        }

        // Filling the thumb rectangle with the foreground color of the scrollbar
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 1, 1); // Rounded rectangle shape with 1-pixel corner radius
    }

    // Nested private class for creating custom scroll bar buttons
    private class ScrollBarButton extends JButton {

        // Constructor for the custom scroll bar button
        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder()); // Setting an empty border to remove any padding
        }

        @Override
        public void paint(Graphics grphcs) {
            // No custom painting for the button, leaving this method empty
        }
    }
}
