// Define the package that this class belongs to
package filter;

// Import the Icon class from javax.swing package
import javax.swing.Icon;

// Define the SearchOption class
public class SearchOption {

    // Private instance variables to store the name and icon of the search option
    private String name;
    private Icon icon;

    // Constructor that takes the name and icon as parameters to initialize the instance variables
    // Parameters: name - the name of the search option, icon - the icon associated with the search option
    public SearchOption(String name, Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    // Default constructor with no parameters
    public SearchOption() {
    }

    // Getter method to retrieve the name of the search option
    // Returns: the name of the search option as a String
    public String getName() {
        return name;
    }

    // Setter method to set the name of the search option
    // Parameters: name - the new name to be set for the search option
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the icon associated with the search option
    // Returns: the icon associated with the search option as an Icon object
    public Icon getIcon() {
        return icon;
    }

    // Setter method to set the icon for the search option
    // Parameters: icon - the new icon to be associated with the search option
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
