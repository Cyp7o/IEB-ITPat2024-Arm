// Define the package that this class belongs to
package swing.scrollbar;

// Import the required classes
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    // Constructor for the custom scrollbar
    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI()); // Setting the custom UI for the scrollbar, no parameters passed
        setPreferredSize(new Dimension(5, 5)); // Setting the preferred size of the scrollbar, Dimension(5, 5) passed
        setForeground(new Color(94, 139, 231)); // Setting the foreground color of the scrollbar, Color(94, 139, 231) passed
        setUnitIncrement(20); // Setting the unit increment for scrolling, 20 passed (type: int)
        setOpaque(false); // Making the scrollbar transparent, no parameters passed
    }
}
