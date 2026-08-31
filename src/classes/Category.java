// Define the package that this class belongs to
package classes;

// Define the Category class
public class Category {

    // Define private fields for the Category class
    private int categoryID; // A unique identifier for the category
    private String category; // The category name

    // Define a constructor that takes both categoryID and category as parameters
    public Category(int categoryID, String category) {
        // Initialize the fields with the provided values
        this.categoryID = categoryID;
        this.category = category;
    }

    // Define a constructor that takes only the category name as a parameter
    public Category(String category) {
        // Initialize the category field with the provided value
        // categoryID is left at its default value (0)
        this.category = category;
    }

    // Getter for the category ID
    public int getCategoryID() {
        return categoryID;
    }

    // Getter for the category name
    public String getCategory() {
        return category;
    }

    // Setter for the category ID
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    // Setter for the category name
    public void setCategory(String category) {
        this.category = category;
    }
}
