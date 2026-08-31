// Define the package that this class belongs to
package classes;

// Import required classes for database operations and logging
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Define the CredentialsManager class to manage login details
public class CredentialsManager {

    // Define the database URL for the Access database
    private static final String DATABASE_URL = "jdbc:ucanaccess://database/PATDB.accdb";

    // Method to check if login details are correct
    public boolean checkLoginDetails(String email, String password) {
        // SQL query to select user with matching email and password
        String sql = "SELECT * FROM Credentials WHERE email = ? AND password = ?";

        // Try-with-resources to ensure resources are closed after usage
        try (
                // Establish a database connection
                Connection conn = DriverManager.getConnection(DATABASE_URL);
                // Prepare the SQL statement
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters for the prepared statement
            stmt.setString(1, email);
            stmt.setString(2, password);

            // Execute the query and get the result set
            try (ResultSet rs = stmt.executeQuery()) {
                // Return true if a matching record is found
                return rs.next();
            }
        } catch (SQLException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
            // Return false if an exception occurs
            return false;
        }
    }

    // Method to get the username by email
    public String getUsername(String email) {
        // SQL query to select the username by email
        String sql = "SELECT Username FROM Credentials WHERE Email = ?";
        String username = null;

        // Try-with-resources to ensure resources are closed after usage
        try (
                // Establish a database connection
                Connection conn = DriverManager.getConnection(DATABASE_URL);
                // Prepare the SQL statement
                PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the parameter for the prepared statement
            ps.setString(1, email);

            // Execute the query and get the result set
            try (ResultSet rs = ps.executeQuery()) {
                // If a matching record is found, retrieve the username
                if (rs.next()) {
                    username = rs.getString("Username");
                }
            }
        } catch (SQLException e) {
            // Log the exception if it occurs
            Logger.getLogger(CredentialsManager.class.getName()).log(Level.SEVERE, "Error retrieving username", e);
        }

        // Return the retrieved username or null if not found
        return username;
    }

    // Method to get the profile picture URL by email
    public String getProfilePic(String email) {
        // SQL query to select the profile picture by email
        String sql = "SELECT ProfilePicture FROM Credentials WHERE email = ?";

        // Try-with-resources to ensure resources are closed after usage
        try (
                // Establish a database connection
                Connection conn = DriverManager.getConnection(DATABASE_URL);
                // Prepare the SQL statement
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set the parameter for the prepared statement
            stmt.setString(1, email);

            // Execute the query and get the result set
            try (ResultSet rs = stmt.executeQuery()) {
                // If a matching record is found, return the profile picture URL
                if (rs.next()) {
                    return rs.getString("ProfilePicture");
                } else {
                    // Return null if no matching record is found
                    return null;
                }
            }
        } catch (SQLException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
            // Return null in case of an exception
            return null;
        }
    }

    // Method to add a new user to the database
    public boolean addUser(Credentials user) {
        // SQL query to insert a new user record
        String sql = "INSERT INTO Credentials (loginID, Username, Email, Password, ProfilePicture) VALUES (?, ?, ?, ?, ?)";

        // Try-with-resources to ensure resources are closed after usage
        try (
                // Establish a database connection
                Connection conn = DriverManager.getConnection(DATABASE_URL);
                // Prepare the SQL statement
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters for the prepared statement
            stmt.setInt(1, user.getLoginID());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getProfilePic());

            // Execute the update and get the number of rows inserted
            int rowsInserted = stmt.executeUpdate();
            // Return true if one or more rows are inserted
            return rowsInserted > 0;
        } catch (SQLException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
            // Return false if an exception occurs
            return false;
        }
    }
}
