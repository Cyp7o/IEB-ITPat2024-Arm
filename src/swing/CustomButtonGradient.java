package swing; // Defines the package for the class

import java.awt.AlphaComposite; // Import for AlphaComposite class
import java.awt.Color; // Import for Color class
import java.awt.Cursor; // Import for Cursor class
import java.awt.GradientPaint; // Import for GradientPaint class
import java.awt.Graphics; // Import for Graphics class
import java.awt.Graphics2D; // Import for Graphics2D class
import java.awt.Point; // Import for Point class
import java.awt.RenderingHints; // Import for RenderingHints class
import java.awt.event.ActionEvent; // Import for ActionEvent class
import java.awt.event.ActionListener; // Import for ActionListener class
import java.awt.event.MouseAdapter; // Import for MouseAdapter class
import java.awt.event.MouseEvent; // Import for MouseEvent class
import java.awt.geom.Path2D; // Import for Path2D class
import java.awt.image.BufferedImage; // Import for BufferedImage class
import javax.swing.JButton; // Import for JButton class
import javax.swing.Timer; // Import for Timer class
import javax.swing.border.EmptyBorder; // Import for EmptyBorder class

public class CustomButtonGradient extends JButton { // Class definition for ButtonGradient, extends JButton

    private Color color1 = Color.decode("#0099F7"); // The first color for the gradient
    private Color color2 = Color.decode("#F11712"); // The second color for the gradient
    private final Timer timer; // Timer for animation
    private final Timer timerPressed; // Timer for pressed animation
    private float alpha = 0.3f; // The alpha value for transparency
    private boolean mouseOver; // Flag indicating if the mouse is over the button
    private boolean pressed; // Flag indicating if the button is pressed
    private Point pressedLocation; // The location where the button was pressed
    private float pressedSize; // The size of the pressed effect
    private float sizeSpeed = 1f; // The speed at which the size changes
    private float alphaPressed = 0.5f; // The alpha value for pressed effect

    public float getSizeSpeed() { // Getter method for retrieving the current size speed
        return sizeSpeed;
    }

    public void setSizeSpeed(float sizeSpeed) { // Setter method for setting the size speed
        this.sizeSpeed = sizeSpeed;
    }

    public Color getColor1() { // Getter method for retrieving the current first color
        return color1;
    }

    public void setColor1(Color color1) { // Setter method for setting the first color
        this.color1 = color1;
    }

    public Color getColor2() { // Getter method for retrieving the current second color
        return color2;
    }

    public void setColor2(Color color2) { // Setter method for setting the second color
        this.color2 = color2;
    }

    public CustomButtonGradient() { // Constructor for ButtonGradient
        setContentAreaFilled(false); // Set the content area to be transparent
        setForeground(Color.WHITE); // Set the foreground color
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set the cursor to hand cursor
        setBorder(new EmptyBorder(10, 20, 10, 20)); // Set an empty border
        addMouseListener(new MouseAdapter() { // Add a mouse listener
            @Override
            public void mouseEntered(MouseEvent me) { // Event handler for mouse enter
                mouseOver = true; // Set the mouse over flag
                timer.start(); // Start the timer for animation
            }

            @Override
            public void mouseExited(MouseEvent me) { // Event handler for mouse exit
                mouseOver = false; // Clear the mouse over flag
                timer.start(); // Start the timer for animation
            }

            @Override
            public void mousePressed(MouseEvent me) { // Event handler for mouse press
                pressedSize = 0; // Reset the pressed size
                alphaPressed = 0.5f; // Reset the pressed alpha
                pressed = true; // Set the pressed flag
                pressedLocation = me.getPoint(); // Set the pressed location
                timerPressed.setDelay(0); // Set the delay for the pressed animation timer
                timerPressed.start(); // Start the timer for pressed animation
            }
        });
        timer = new Timer(40, new ActionListener() { // Create a timer for animation
            @Override
            public void actionPerformed(ActionEvent ae) { // Event handler for timer
                if (mouseOver) { // If mouse is over the button
                    if (alpha < 0.6f) { // If alpha is less than 0.6
                        alpha += 0.05f; // Increase the alpha
                        repaint(); // Repaint the button
                    } else {
                        alpha = 0.6f; // Set the alpha to 0.6
                        timer.stop(); // Stop the timer
                        repaint(); // Repaint the button
                    }
                } else { // If mouse is not over the button
                    if (alpha > 0.3f) { // If alpha is greater than 0.3
                        alpha -= 0.05f; // Decrease the alpha
                        repaint(); // Repaint the button
                    } else {
                        alpha = 0.3f; // Set the alpha to 0.3
                        timer.stop(); // Stop the timer
                        repaint(); // Repaint the button
                    }
                }
            }
        });
        timerPressed = new Timer(0, new ActionListener() { // Create a timer for pressed animation
            @Override
            public void actionPerformed(ActionEvent ae) { // Event handler for timer
                pressedSize += getSizeSpeed(); // Increase the pressed size
                if (alphaPressed <= 0) { // If pressed alpha is less than or equal to 0
                    pressed = false; // Clear the pressed flag
                    timerPressed.stop(); // Stop the timer
                } else {
                    repaint(); // Repaint the button
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) { // Method for painting the component
        int width = getWidth(); // Get the width of the component
        int height = getHeight(); // Get the height of the component
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Create a buffered image
        Graphics2D g2 = img.createGraphics(); // Create a graphics object for the buffered image
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Set rendering hints for antialiasing
        //  Create Gradients Color
        GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2); // Create a gradient paint
        g2.setPaint(gra); // Set the paint for the graphics object
        g2.fillRoundRect(0, 0, width, height, height, height); // Fill a rounded rectangle with the gradient
        //  Add Style
        createStyle(g2); // Apply additional style to the graphics object
        if (pressed) { // If the button is pressed
            paintPressed(g2); // Apply pressed effect to the graphics object
        }
        g2.dispose(); // Dispose the graphics object
        grphcs.drawImage(img, 0, 0, null); // Draw the image on the component
        super.paintComponent(grphcs); // Call the superclass method for painting the component
    }

    private void createStyle(Graphics2D g2) { // Method for creating additional style
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha)); // Set composite for transparency
        int width = getWidth(); // Get the width of the component
        int height = getHeight(); // Get the height of the component
        GradientPaint gra = new GradientPaint(0, 0, Color.WHITE, 0, height, new Color(255, 255, 255, 60)); // Create a gradient paint
        g2.setPaint(gra); // Set the paint for the graphics object
        Path2D.Float f = new Path2D.Float(); // Create a path
        f.moveTo(0, 0); // Move to the starting point of the path
        int controll = height + height / 2; // Calculate the control point for the curve
        f.curveTo(0, 0, width / 2, controll, width, 0); // Create a curved path
        g2.fill(f); // Fill the path
    }

    private void paintPressed(Graphics2D g2) { // Method for painting the pressed effect
        if (pressedLocation.x - (pressedSize / 2) < 0 && pressedLocation.x + (pressedSize / 2) > getWidth()) {
            timerPressed.setDelay(20); // Set the delay for the pressed animation timer
            alphaPressed -= 0.05f; // Decrease the pressed alpha
            if (alphaPressed < 0) { // If pressed alpha is less than 0
                alphaPressed = 0; // Set the pressed alpha to 0
            }
        }
        g2.setColor(Color.WHITE); // Set the color to white
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed)); // Set composite for pressed effect transparency
        float x = pressedLocation.x - (pressedSize / 2); // Calculate the x-coordinate for the pressed effect
        float y = pressedLocation.y - (pressedSize / 2); // Calculate the y-coordinate for the pressed effect
        g2.fillOval((int) x, (int) y, (int) pressedSize, (int) pressedSize); // Fill an oval with the pressed effect
    }
}
