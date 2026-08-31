// Define the package that this class belongs to
package classes;

// Import necessary classes for database operations and logging
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Define the CategoryManager class
public class CategoryManager {

    // Define private fields for the CategoryManager class
    private ConnectDB db; // An instance of the ConnectDB class for handling database connections
    private Category[] cArr = new Category[200]; // An array to store Category objects
    private int size = 0; // A counter to keep track of the number of categories currently stored

    // Define a constructor for the CategoryManager class
    public CategoryManager() {
        try {
            // Initialize the ConnectDB instance
            db = new ConnectDB();
            // SQL query to select all rows from the Categories table
            String sql = "SELECT * FROM Categories";
            // Execute the query and retrieve the results
            ResultSet rs = db.getResults(sql);
            // Process the results and populate the category array
            while (rs.next()) {
                // Create a new Category object and add it to the array
                cArr[size] = new Category(rs.getInt("CategoryID"), rs.getString("Category"));
                size++;
            }
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur during initialization
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Define a method to add all category data to a table model
    public void addDataToTable(DefaultTableModel model) {
        // Clear existing data in the table model
        model.setRowCount(0);
        // Add each category's data as a new row in the table model
        for (int i = 0; i < size; i++) {
            model.addRow(new Object[]{cArr[i].getCategoryID(), cArr[i].getCategory()});
        }
    }

    // Define a method to add searched category data to a table model
    public void addSearchedDataToTable(DefaultTableModel model, String where, Object... search) {
        try {
            // Clear existing data in the table model
            model.setRowCount(0);
            // Construct SQL query with a WHERE clause for filtering results
            String sql = "SELECT * FROM Categories " + where;
            // Create a PreparedStatement object to execute the query
            PreparedStatement ps = db.getConn().prepareStatement(sql);

            // Set the parameters for the PreparedStatement based on search criteria
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }

            // Execute the PreparedStatement and get the results
            ResultSet rs = ps.executeQuery();

            // Process the results and add each category's data to the table model
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("CategoryID"), rs.getString("Category")});
            }
            // Close the ResultSet and PreparedStatement
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur during the search process
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Define a method to add a new category to the database
    public void addCategory(Category category) {
        // SQL query to insert a new category into the Categories table
        String sql = "INSERT INTO Categories(Category) VALUES(?)";
        try {
            // Create a PreparedStatement object for the insert operation
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            // Set the parameter for the PreparedStatement with the category name
            ps.setString(1, category.getCategory());
            // Execute the PreparedStatement to insert the new category
            ps.executeUpdate();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur during the insert operation
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Define a method to delete a category from the database
    public void deleteCategory(int categoryID) {
        // SQL query to delete a category from the Categories table by ID
        String sql = "DELETE FROM Categories WHERE CategoryID = ?";
        try {
            // Create a PreparedStatement object for the delete operation
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            // Set the parameter for the PreparedStatement with the category ID
            ps.setInt(1, categoryID);
            // Execute the PreparedStatement to delete the category
            ps.executeUpdate();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur during the delete operation
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
