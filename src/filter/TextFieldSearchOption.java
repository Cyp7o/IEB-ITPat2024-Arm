// Define the package that this class belongs to
package filter;

// Import the required classes
import filter.SearchOption;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import filter.SearchOptionEvent;

public class TextFieldSearchOption extends JTextField {

    // Animator object for handling animation
    private Animator animator;
    // The animate value used for animation
    private float animate;
    // A boolean flag to indicate if the search option is open or closed
    private boolean option = false;
    // The shape representing the search option's overlay
    private Shape shape;
    // A boolean flag to track if the mouse is pressed
    private boolean mousePressed = false;
    // List to store search options
    private final List<SearchOption> items = new ArrayList<>();
    // List to store events associated with search option selection
    private final List<SearchOptionEvent> events = new ArrayList<>();
    // Index of the currently selected search option
    private int selectedIndex = -1;
    // Index of the search option pressed by the mouse
    private int pressedIndex = -1;
    // Color used for the first overlay gradient
    private Color colorOverlay1 = new Color(40, 170, 240);
    // Color used for the second overlay gradient
    private Color colorOverlay2 = new Color(138, 39, 232);
    // Hint text to display when the text field is empty
    private String hint = "Search...";

    // Constructor
    public TextFieldSearchOption() {
        // Set the border and selection color for the text field
        setBorder(new EmptyBorder(10, 10, 10, 40));
        setSelectionColor(new Color(25, 141, 255));

        // MouseAdapter to handle mouse events
        MouseAdapter mouseEvent = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                // Change cursor to hand cursor if the mouse is over the search option overlay
                if (isOver(me.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    // Change cursor to hand cursor if the search option is open, else text cursor
                    if (option) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    } else {
                        setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    // Check if the mouse press is on the search option overlay
                    mousePressed = isOver(me.getPoint());
                    if (!mousePressed) {
                        // Check which search option is pressed by the mouse
                        pressedIndex = checkPress(me.getPoint());
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    // Check if the animator is not running (prevents overlapping animations)
                    if (!animator.isRunning()) {
                        // If the mouse is pressed on the search option overlay, start the animation
                        if (mousePressed && isOver(me.getPoint())) {
                            startAnimate();
                        } else {
                            // Check which search option is released by the mouse and handle its selection
                            int index = checkPress(me.getPoint());
                            if (index != -1) {
                                if (index == pressedIndex) {
                                    selectedIndex = index;
                                    runEvent();
                                    startAnimate();
                                }
                            }
                        }
                    }
                }
            }
        };

        // Add the mouse event listeners to the text field
        addMouseMotionListener(mouseEvent);
        addMouseListener(mouseEvent);

        // Focus adapter to handle focus events
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent fe) {
                // Start animation if the search option is open and the text field loses focus
                if (option) {
                    startAnimate();
                }
            }
        });

        // Initialize the animator used for animation
        initAnimator();
    }

    // Getter and setter methods for hint, colorOverlay1, and colorOverlay2
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Color getColorOverlay1() {
        return colorOverlay1;
    }

    public void setColorOverlay1(Color colorOverlay1) {
        this.colorOverlay1 = colorOverlay1;
    }

    public Color getColorOverlay2() {
        return colorOverlay2;
    }

    public void setColorOverlay2(Color colorOverlay2) {
        this.colorOverlay2 = colorOverlay2;
    }

    // Method to add a search option
    public void addOption(SearchOption option) {
        items.add(option);
        // If no search option is selected, select the first one and run its associated event
        if (selectedIndex == -1) {
            selectedIndex = 0;
            runEvent();
        }
    }

    // Method to add a search option event
    public void addEventOptionSelected(SearchOptionEvent event) {
        events.add(event);
    }

    // Method to get the currently selected search option
    public SearchOption getSelectedOption() {
        if (selectedIndex == -1) {
            return null;
        } else {
            return items.get(selectedIndex);
        }
    }

    // Method to check if a search option is selected
    public boolean isSelected() {
        return selectedIndex >= 0;
    }

    // Method to set the selected search option index
    public void setSelectedIndex(int index) {
        selectedIndex = index;
        runEvent();
        repaint();
    }

    // Method to get the selected search option index
    public int getSelectedIndex() {
        return selectedIndex;
    }

    // Method to run the event associated with the selected search option
    private void runEvent() {
        for (SearchOptionEvent event : events) {
            event.optionSelected(getSelectedOption(), selectedIndex);
        }
    }

    // Method to start the search option overlay animation
    private void startAnimate() {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        option = !option;
        animator.start();
    }

    // Method to check if the mouse is over the search option overlay
    private boolean isOver(Point mouse) {
        if (!option) {
            return shape.contains(mouse);
        }
        return false;
    }

    // Method to check which search option is pressed by the mouse
    private int checkPress(Point mouse) {
        int index = -1;
        if (!items.isEmpty() && option) {
            double width = getWidth() / items.size();
            for (int i = 0; i < items.size(); i++) {
                if (new Rectangle2D.Double(width * i, 0, width, getHeight()).contains(mouse)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    // Method to initialize the animator used for animation
    private void initAnimator() {
        animator = new Animator(500, new TimingTargetAdapter() {
            @Override
            public void begin() {
                setEditable(!option);
            }

            @Override
            public void timingEvent(float fraction) {
                if (option) {
                    animate = fraction;
                } else {
                    animate = 1f - fraction;
                }
                repaint();
            }
        });
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
    }

    // Override the paintComponent method to customize the appearance of the text field
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(151, 151, 151));
        g2.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        if (isFocusOwner()) {
            g2.setColor(new Color(60, 158, 255));
            g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
        g2.dispose();
        super.paintComponent(grphcs);
    }

    // Override the paint method to customize the appearance of the search option overlay
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintHint(g2);
        double x = getWidth() - 35;
        double y = 2;
        x -= (x - 2) * animate;
        double height = getHeight() - 4;
        double round = height - height * animate;
        Area area = new Area(new RoundRectangle2D.Double(x, y, height, height, round, round));
        Path2D p = new Path2D.Double();
        p.moveTo(x + height / 2, y);
        p.lineTo(getWidth() - 2, y);
        p.lineTo(getWidth() - 2, y + height);
        p.lineTo(x + height / 2, y + height);
        area.add(new Area(p));
        g2.setPaint(new GradientPaint(new Point2D.Double(x, 0), colorOverlay1, new Point2D.Double(getWidth(), 0), colorOverlay2));
        g2.fill(area);
        shape = area;
        drawItem(g2, x, y, getWidth() - 2, height);
        g2.dispose();
    }

    // Method to paint the hint text on the text field
    private void paintHint(Graphics2D g2) {
        if (getText().length() == 0) {
            int h = getHeight();
            Insets ins = getInsets();
            FontMetrics fm = g2.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g2.setColor(new Color(c2, true));
            g2.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

    // Method to draw each search option's icon
    private void drawItem(Graphics2D g2, double x, double y, double width, double height) {
        double w = width - x;
        double per = w / items.size();
        for (int i = 0; i < items.size(); i++) {
            drawIcon(g2, x + i * per, y, per, height, i);
        }
    }

    // Method to draw an icon for a search option
    private void drawIcon(Graphics2D g2, double x, double y, double width, double height, int index) {
        Composite oldComposite = g2.getComposite();
        if (index != selectedIndex) {
            // Set transparency for unselected search options during animation
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, animate));
        } else {
            // Adjust width and x position for selected search option during animation
            width = (width <= 35 ? 35 : width);
            x = (x > getWidth() - 34 ? getWidth() - 34 : x);
        }
        // Draw the search option's icon
        ImageIcon image = toImage(index);
        double ix = x + ((width - image.getIconWidth()) / 2);
        double iy = y + ((height - image.getIconHeight()) / 2);
        g2.drawImage(image.getImage(), (int) ix, (int) iy, null);
        g2.setComposite(oldComposite);
    }

    // Method to convert a search option to an ImageIcon
    private ImageIcon toImage(int index) {
        return (ImageIcon) items.get(index).getIcon();
    }
}
