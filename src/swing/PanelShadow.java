package swing; // Declares the package "swing"

import swing.shadow.ShadowRenderer; // Imports the class "ShadowRenderer" from the package "swing.shadow"
import java.awt.Color; // Imports the class "Color" from the "java.awt" package
import java.awt.Graphics; // Imports the class "Graphics" from the "java.awt" package
import java.awt.Graphics2D; // Imports the class "Graphics2D" from the "java.awt" package
import java.awt.RenderingHints; // Imports the class "RenderingHints" from the "java.awt" package
import java.awt.image.BufferedImage; // Imports the class "BufferedImage" from the "java.awt.image" package
import javax.swing.JPanel; // Imports the class "JPanel" from the "javax.swing" package
import swing.ShadowType;

public class PanelShadow extends JPanel { // Defines a class named "PanelShadow" that extends the "JPanel" class

    private ShadowType shadowType = ShadowType.CENTER; // Declares and initializes the private instance variable "shadowType" with the value ShadowType.CENTER
    private int shadowSize = 10; // Declares and initializes the private instance variable "shadowSize" with the value 10
    private float shadowOpacity = 0.3f; // Declares and initializes the private instance variable "shadowOpacity" with the value 0.3
    private Color shadowColor = new Color(48, 44, 90); // Declares and initializes the private instance variable "shadowColor" with the RGB color (48, 44, 90)
    private BufferedImage shadowImage; // Declares the private instance variable "shadowImage" of type BufferedImage

    public PanelShadow() { // Constructor for the "PanelShadow" class
        setOpaque(false); // Sets the panel to be transparent
    }

    public ShadowType getShadowType() { // Defines a getter method for the "shadowType" property
        return shadowType;
    }

    public void setShadowType(ShadowType shadowType) { // Defines a setter method for the "shadowType" property
        this.shadowType = shadowType;
    }

    public int getShadowSize() { // Defines a getter method for the "shadowSize" property
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) { // Defines a setter method for the "shadowSize" property
        this.shadowSize = shadowSize;
    }

    public float getShadowOpacity() { // Defines a getter method for the "shadowOpacity" property
        return shadowOpacity;
    }

    public void setShadowOpacity(float shadowOpacity) { // Defines a setter method for the "shadowOpacity" property
        this.shadowOpacity = shadowOpacity;
    }

    public Color getShadowColor() { // Defines a getter method for the "shadowColor" property
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) { // Defines a setter method for the "shadowColor" property
        this.shadowColor = shadowColor;
    }

    @Override
    protected void paintComponent(Graphics grphcs) { // Overrides the "paintComponent" method to customize the painting behavior
        grphcs.drawImage(shadowImage, 0, 0, null); // Draws the shadow image onto the panel
        super.paintComponent(grphcs); // Calls the superclass's "paintComponent" method to perform additional painting tasks
    }

    private void createShadow() { // Private method "createShadow" responsible for generating the shadow effect
        int size = shadowSize * 2; // Calculates the shadow size based on the "shadowSize" property
        int x = 0; // Initializes the x-coordinate for the shadow
        int y = 0; // Initializes the y-coordinate for the shadow
        int width = getWidth() - size; // Calculates the width of the shadow area
        int height = getHeight() - size; // Calculates the height of the shadow area

        if (shadowType == ShadowType.TOP) { // Checks if the shadow type is "TOP"
            x = shadowSize; // Sets the x-coordinate for the shadow based on the shadow size
            y = size; // Sets the y-coordinate for the shadow based on the shadow size
        } else if (shadowType == ShadowType.BOT) { // Checks if the shadow type is "BOT"
            x = shadowSize; // Sets the x-coordinate for the shadow based on the shadow size
            y = 0; // Sets the y-coordinate for the shadow to 0
        } else if (shadowType == ShadowType.TOP_LEFT) { // Checks if the shadow type is "TOP_LEFT"
            x = size; // Sets the x-coordinate for the shadow based on the shadow size
            y = size; // Sets the y-coordinate for the shadow based on the shadow size
        } else if (shadowType == ShadowType.TOP_RIGHT) { // Checks if the shadow type is "TOP_RIGHT"
            x = 0; // Sets the x-coordinate for the shadow to 0
            y = size; // Sets the y-coordinate for the shadow based on the shadow size
        } else if (shadowType == ShadowType.BOT_LEFT) { // Checks if the shadow type is "BOT_LEFT"
            x = size; // Sets the x-coordinate for the shadow based on the shadow size
            y = 0; // Sets the y-coordinate for the shadow to 0
        } else if (shadowType == ShadowType.BOT_RIGHT) { // Checks if the shadow type is "BOT_RIGHT"
            x = 0; // Sets the x-coordinate for the shadow to 0
            y = 0; // Sets the y-coordinate for the shadow to 0
        } else { // If the shadow type is not any of the above cases
            //  Center
            x = shadowSize; // Sets the x-coordinate for the shadow based on the shadow size
            y = shadowSize; // Sets the y-coordinate for the shadow based on the shadow size
        }

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Creates a new BufferedImage with the specified dimensions
        Graphics2D g = img.createGraphics(); // Obtains the Graphics2D object to draw on the BufferedImage
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Sets rendering hints for better graphics quality
        g.setColor(getBackground()); // Sets the color for drawing the background of the image
        g.fillRoundRect(0, 0, width, height, 10, 10); // Fills a rounded rectangle on the image

        //  Create Shadow
        ShadowRenderer render = new ShadowRenderer(shadowSize, shadowOpacity, shadowColor); // Creates a ShadowRenderer object with the specified shadow properties
        shadowImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB); // Creates a new BufferedImage with the size of the panel
        Graphics2D g2 = shadowImage.createGraphics(); // Obtains the Graphics2D object to draw on the shadowImage
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Sets rendering hints for better graphics quality
        g2.drawImage(render.createShadow(img), 0, 0, null); // Draws the shadow onto the shadowImage
        g2.fillRoundRect(x, y, width, height, 10, 10); // Fills a rounded rectangle on the shadowImage
        g2.dispose(); // Disposes the Graphics2D object

    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) { // Overrides the "setBounds" method to adjust the panel's bounds
        super.setBounds(i, i1, i2, i3); // Calls the superclass's "setBounds" method
        createShadow(); // Calls the "createShadow" method to update the shadow effect
    }
}
