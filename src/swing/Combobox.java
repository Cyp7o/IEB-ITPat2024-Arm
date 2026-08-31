// Define the package that this class belongs to
package swing;

// Import the required classes
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing.scrollbar.ScrollBarCustom;

// Custom Combobox class that extends JComboBox with a custom UI
public class Combobox<E> extends JComboBox<E> {

    // Private fields
    private String labeText = "Label";  // Default label text
    private Color lineColor = new Color(3, 155, 216);  // Default line color
    private boolean mouseOver;  // Flag to track mouse over state

    // Constructor
    public Combobox() {
        setBackground(Color.WHITE);  // Set background color to white
        setBorder(new EmptyBorder(15, 3, 5, 3));  // Set empty borders
        setUI(new ComboUI(this));  // Set custom UI for the combo box
        setRenderer(new DefaultListCellRenderer() {  // Customize list cell rendering
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                Component com = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                setBorder(new EmptyBorder(5, 5, 5, 5));  // Set empty cell borders
                if (bln) {
                    com.setBackground(new Color(240, 240, 240));  // Set background color when selected
                }
                return com;
            }
        });
    }

    // Getter method for label text
    public String getLabeText() {
        return labeText;
    }

    // Setter method for label text
    public void setLabeText(String labeText) {
        this.labeText = labeText;
    }

    // Getter method for line color
    public Color getLineColor() {
        return lineColor;
    }

    // Setter method for line color
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    // Private inner class that implements a custom UI for the combobox
    private class ComboUI extends BasicComboBoxUI {

        // Private fields
        private final Animator animator;  // Animation for the hint text
        private boolean animateHinText = true;  // Flag to animate the hint text
        private float location;  // Current animation location
        private boolean show;  // Flag to control showing the hint text
        private Combobox combo;  // Reference to the parent Combobox instance

        // Constructor
        public ComboUI(Combobox combo) {
            this.combo = combo;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    mouseOver = true;  // Set the mouse over flag
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    mouseOver = false;  // Set the mouse over flag
                    repaint();
                }
            });
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent fe) {
                    showing(false);  // Start showing animation
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    showing(true);  // Start hiding animation
                }
            });
            addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (!isFocusOwner()) {
                        if (getSelectedIndex() == -1) {
                            showing(true);  // Start showing animation
                        } else {
                            showing(false);  // Start hiding animation
                        }
                    }
                }
            });
            addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(200, 200, 200));  // Change arrow button background when the popup is about to be shown
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));  // Change arrow button background when the popup is about to be hidden
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));  // Change arrow button background when the popup is canceled
                }
            });
            TimingTarget target = new TimingTargetAdapter() {
                @Override
                public void begin() {
                    animateHinText = getSelectedIndex() == -1;  // Set the animation flag based on selected index
                }

                @Override
                public void timingEvent(float fraction) {
                    location = fraction;  // Update animation location
                    repaint();
                }

            };
            animator = new Animator(300, target);  // Create the animator with a duration of 300 milliseconds
            animator.setResolution(0);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
        }

        // Override paintCurrentValueBackground method to do nothing (no background painting)
        @Override
        public void paintCurrentValueBackground(Graphics grphcs, Rectangle rctngl, boolean bln) {
            // Do nothing, we don't want the default background painting
        }

        // Override createArrowButton method to use a custom ArrowButton
        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();  // Return a new instance of the custom ArrowButton
        }

        // Override createPopup method to use a custom BasicComboPopup
        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup pop = new BasicComboPopup(comboBox) {
                @Override
                protected JScrollPane createScroller() {
                    list.setFixedCellHeight(30);  // Set fixed cell height for the list items
                    JScrollPane scroll = new JScrollPane(list);  // Create a scroll pane for the list
                    scroll.setBackground(Color.WHITE);  // Set scroll pane background color to white
                    ScrollBarCustom sb = new ScrollBarCustom();  // Create a custom scrollbar
                    sb.setUnitIncrement(30);  // Set the scroll increment for the custom scrollbar
                    sb.setForeground(new Color(180, 180, 180));  // Set the scroll bar color
                    scroll.setVerticalScrollBar(sb);  // Use the custom scrollbar in the scroll pane
                    return scroll;  // Return the customized scroll pane
                }
            };
            pop.setBorder(new LineBorder(new Color(200, 200, 200), 1));  // Set the popup border
            return pop;  // Return the customized popup
        }

        // Override paint method to paint the custom UI
        @Override
        public void paint(Graphics grphcs, JComponent jc) {
            super.paint(grphcs, jc);  // Call the superclass paint method
            Graphics2D g2 = (Graphics2D) grphcs;  // Cast to Graphics2D for more advanced drawing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Enable anti-aliasing
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);  // Enable text anti-aliasing
            int width = getWidth();  // Get the width of the component
            int height = getHeight();  // Get the height of the component
            if (mouseOver) {
                g2.setColor(lineColor);  // Use the custom line color when the mouse is over the component
            } else {
                g2.setColor(new Color(150, 150, 150));  // Use the default line color
            }
            g2.fillRect(2, height - 1, width - 4, 1);  // Draw a line at the bottom of the component
            createHintText(g2);  // Draw the hint text
            createLineStyle(g2);  // Draw the line style (animated underline)
            g2.dispose();  // Dispose of the Graphics2D object
        }

        // Helper method to create the hint text
        private void createHintText(Graphics2D g2) {
            Insets in = getInsets();  // Get the insets of the component (padding)
            g2.setColor(new Color(150, 150, 150));  // Use the default text color for the hint text
            FontMetrics ft = g2.getFontMetrics();  // Get the font metrics for text measurement
            Rectangle2D r2 = ft.getStringBounds(combo.getLabeText(), g2);  // Get the bounding rectangle of the label text
            double height = getHeight() - in.top - in.bottom;  // Calculate available height for drawing text
            double textY = (height - r2.getHeight()) / 2;  // Calculate the Y-coordinate for drawing text vertically centered
            double size;
            if (animateHinText) {
                if (show) {
                    size = 18 * (1 - location);  // Animate the hint text size
                } else {
                    size = 18 * location;  // Animate the hint text size
                }
            } else {
                size = 18;  // Use the default hint text size
            }
            g2.drawString(combo.getLabeText(), in.right, (int) (in.top + textY + ft.getAscent() - size));  // Draw the hint text
        }

        // Helper method to create the line style (animated underline)
        private void createLineStyle(Graphics2D g2) {
            if (isFocusOwner()) {
                double width = getWidth() - 4;  // Calculate available width for drawing the line
                int height = getHeight();  // Get the height of the component
                g2.setColor(lineColor);  // Use the custom line color
                double size;
                if (show) {
                    size = width * (1 - location);  // Animate the line size
                } else {
                    size = width * location;  // Animate the line size
                }
                double x = (width - size) / 2;  // Calculate the X-coordinate for drawing the line centered horizontally
                g2.fillRect((int) (x + 2), height - 2, (int) size, 2);  // Draw the line at the bottom of the component
            }
        }

        // Helper method to control the showing and hiding animation of the hint text
        private void showing(boolean action) {
            if (animator.isRunning()) {
                animator.stop();  // Stop the animator if it's running
            } else {
                location = 1;  // Reset the animation location
            }
            animator.setStartFraction(1f - location);  // Set the start fraction for the animation
            show = action;  // Set the show flag based on the given action
            location = 1f - location;  // Invert the animation location
            animator.start();  // Start the animator
        }

        // Private inner class for the custom arrow button
        private class ArrowButton extends JButton {

            // Constructor
            public ArrowButton() {
                setContentAreaFilled(false);  // Don't fill the content area (transparent button)
                setBorder(new EmptyBorder(5, 5, 5, 5));  // Set empty borders
                setBackground(new Color(150, 150, 150));  // Set default background color
            }

            // Override paint method to draw a custom arrow icon
            @Override
            public void paint(Graphics grphcs) {
                super.paint(grphcs);  // Call the superclass paint method
                Graphics2D g2 = (Graphics2D) grphcs;  // Cast to Graphics2D for more advanced drawing
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Enable anti-aliasing
                int width = getWidth();  // Get the width of the button
                int height = getHeight();  // Get the height of the button
                int size = 10;  // Set the size of the arrow icon
                int x = (width - size) / 2;  // Calculate the X-coordinate for drawing the arrow centered horizontally
                int y = (height - size) / 2 + 5;  // Calculate the Y-coordinate for drawing the arrow centered vertically
                int px[] = {x, x + size, x + size / 2};  // X-coordinates for the arrow polygon
                int py[] = {y, y, y + size};  // Y-coordinates for the arrow polygon
                g2.setColor(getBackground());  // Use the button background color for the arrow
                g2.fillPolygon(px, py, px.length);  // Draw the arrow polygon
                g2.dispose();  // Dispose of the Graphics2D object
            }
        }
    }
}
