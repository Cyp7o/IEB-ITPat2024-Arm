// Package declaration
// This class is part of the 'classes' package.
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PropertyManager {

    private ConnectDB db; // Database connection instance
    private Property[] pArr = new Property[200]; // Array to store Property objects
    private int size = 0; // Counter to keep track of the number of properties

    // Constructor for the PropertyManager class
    public PropertyManager() {
        try {
            db = new ConnectDB(); // Initialize database connection
            String sql = "SELECT * FROM Properties"; // SQL query to get all properties
            ResultSet rs = db.getResults(sql); // Execute query and get results
            while (rs.next()) {
                // Create Property object and add it to the array
                pArr[size++] = new Property(
                    rs.getInt("PropertyID"),
                    rs.getString("Suburb"),
                    rs.getString("Complex"),
                    rs.getString("UnitNo"),
                    rs.getString("Address"),
                    rs.getString("Category"),
                    rs.getInt("Bedrooms"),
                    rs.getDouble("Bathrooms"),
                    rs.getBoolean("Occupied"),
                    rs.getInt("Rent"),
                    rs.getString("Image")
                );
            }
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add all property data to a table model
    public void addDataToTable(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing rows
        for (int i = 0; i < size; i++) {
            // Add each property as a row in the table model
            model.addRow(new Object[]{
                pArr[i].getPropertyID(),
                pArr[i].getComplex(),
                pArr[i].getUnitNo(),
                pArr[i].getAddress(),
                pArr[i].getSuburb(),
                pArr[i].getCategory(),
                pArr[i].getBedrooms(),
                pArr[i].getBathrooms(),
                pArr[i].isOccupied(),
                pArr[i].getRent(),
                pArr[i].getImage()
            });
        }
    }

    // Method to add searched property data to a table model
    public void addSearchedDataToTable(DefaultTableModel model, String where, Object... search) {
        model.setRowCount(0); // Clear existing rows
        try {
            String sql = "SELECT * FROM Properties " + where; // SQL query with where clause
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Prepare statement

            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]); // Set search parameters
            }

            ResultSet rs = ps.executeQuery(); // Execute query
            while (rs.next()) {
                // Add each result as a row in the table model
                model.addRow(new Object[]{
                    rs.getInt("PropertyID"),
                    rs.getString("Complex"),
                    rs.getString("UnitNo"),
                    rs.getString("Address"),
                    rs.getString("Suburb"),
                    rs.getString("Category"),
                    rs.getInt("Bedrooms"),
                    rs.getDouble("Bathrooms"),
                    rs.getBoolean("Occupied"),
                    rs.getInt("Rent"),
                    rs.getString("Image")
                });
            }
            rs.close(); // Close result set
            ps.close(); // Close prepared statement
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add a property to the database
    public void addProperty(String complex, String unitNo, String address, String suburb, String category, int bedrooms, double bathrooms, int rent, String image) {
        try {
            String sql = "INSERT INTO Properties (Complex, UnitNo, Address, Suburb, Category, Bedrooms, Bathrooms, Rent, Image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert query
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Prepare statement
            ps.setString(1, complex);
            ps.setString(2, unitNo);
            ps.setString(3, address);
            ps.setString(4, suburb);
            ps.setString(5, category);
            ps.setInt(6, bedrooms);
            ps.setDouble(7, bathrooms);
            ps.setInt(8, rent);
            ps.setString(9, image);
            ps.executeUpdate(); // Execute insert
            ps.close(); // Close prepared statement
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to delete a property from the database
    public void deleteProperty(int propertyID) {
        try {
            String sql = "DELETE FROM Properties WHERE PropertyID = ?"; // SQL delete query
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Prepare statement
            ps.setInt(1, propertyID);
            ps.executeUpdate(); // Execute delete
            ps.close(); // Close prepared statement
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to update an existing property in the database
    public void editProperty(Property property) {
        try {
            String sql = "UPDATE Properties SET Complex = ?, UnitNo = ?, Address = ?, Suburb = ?, Category = ?, Bedrooms = ?, Bathrooms = ?, Occupied = ?, Rent = ?, Image = ? WHERE PropertyID = ?"; // SQL update query
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Prepare statement
            ps.setString(1, property.getComplex());
            ps.setString(2, property.getUnitNo());
            ps.setString(3, property.getAddress());
            ps.setString(4, property.getSuburb());
            ps.setString(5, property.getCategory());
            ps.setInt(6, property.getBedrooms());
            ps.setDouble(7, property.getBathrooms());
            ps.setBoolean(8, property.isOccupied());
            ps.setInt(9, property.getRent());
            ps.setString(10, property.getImage());
            ps.setInt(11, property.getPropertyID());
            ps.executeUpdate(); // Execute update
            ps.close(); // Close prepared statement
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to get the list of distinct categories from the Categories table
    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        String sql = "SELECT DISTINCT Category FROM Categories"; // SQL query to get distinct categories
        try {
            ResultSet rs = db.getResults(sql); // Execute query and get results
            while (rs.next()) {
                categories.add(rs.getString("Category")); // Add each category to the list
            }
            rs.close(); // Close result set
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    // Method to get the total number of entries in the Properties table
    public int getTotalEntries() {
        String sql = "SELECT COUNT(*) FROM Properties"; // SQL query to count total entries
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Prepare statement
            ResultSet rs = ps.executeQuery(); // Execute query
            if (rs.next()) {
                int count = rs.getInt(1); // Get the count from result set
                rs.close(); // Close result set
                ps.close(); // Close prepared statement
                return count;
            }
        } catch (SQLException ex) {
            // Log SQL exceptions
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // Return 0 if there was an exception
    }

    // Private method to filter and sort table by specified column and order
    private void filterTable(javax.swing.JTable tblProperties, int columnIndex, SortOrder order) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblProperties.getModel()); // Create sorter
        tblProperties.setRowSorter(sorter); // Set the sorter on the table
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(); // List to store sort keys
        sortKeys.add(new RowSorter.SortKey(columnIndex, order)); // Add sort key for the specified column and order
        sorter.setSortKeys(sortKeys); // Set sort keys on the sorter
        sorter.sort(); // Perform the sort
    }

    // Public method to sort the table based on the selected option
    public void sortTable(javax.swing.JTable tblProperties, String selectedOption) {
        switch (selectedOption) {
            case "None":
                tblProperties.setRowSorter(null); // Remove sorter
                break;
            case "Complex (A to Z)":
                filterTable(tblProperties, 1, SortOrder.ASCENDING); // Sort by complex in ascending order
                break;
            case "Complex (Z to A)":
                filterTable(tblProperties, 1, SortOrder.DESCENDING); // Sort by complex in descending order
                break;
            case "Bedrooms (Low to High)":
                filterTable(tblProperties, 6, SortOrder.ASCENDING); // Sort by bedrooms in ascending order
                break;
            case "Bedrooms (High to Low)":
                filterTable(tblProperties, 6, SortOrder.DESCENDING); // Sort by bedrooms in descending order
                break;
            case "Rent (Low to High)":
                filterTable(tblProperties, 9, SortOrder.ASCENDING); // Sort by rent in ascending order
                break;
            case "Rent (High to Low)":
                filterTable(tblProperties, 9, SortOrder.DESCENDING); // Sort by rent in descending order
                break;
            default:
                tblProperties.setRowSorter(null); // Default case: remove sorter
                break;
        }
    }

    // Method to get a property by its ID
    public Property getProperty(int id) {
        for (Property p : pArr) {
            if (p != null && p.getPropertyID() == id) {
                return p; // Return the property if the ID matches
            }
        }
        return null; // Return null if no property matches the ID
    }
}
