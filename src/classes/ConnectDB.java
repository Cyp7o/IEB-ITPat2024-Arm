// Define the package that this class belongs to
package classes;

// Import the required classes
import java.sql.*;

// Define the ConnectDB class
public class ConnectDB {

    // Define private fields for the connection, statement, and result set
    private Connection conn; // Connection object used to connect to the database
    private Statement stmt; // Statement object used to execute SQL statements
    private ResultSet rs; // ResultSet object used to store the results of an SQL query

    // Define a constructor for the ConnectDB class
    public ConnectDB() {
        try {
            // Define the URL to the database and create a connection to it using the UCanAccess driver
            String url = "jdbc:ucanaccess://database/PATDB.accdb";
            conn = DriverManager.getConnection(url);
            // Create a new Statement object for executing SQL statements
            stmt = conn.createStatement();
        } catch (SQLException e) {
            // If an exception is thrown, print an error message to the console
            System.out.println("Problem Connecting to database " + e);
        }
    }

    // Define a method called "getResults" that takes a Query string as a parameter
    public ResultSet getResults(String query) {
        try {
            // Execute the SQL query specified in the Query parameter and store the results in the rs field
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            // If an exception is thrown, print an error message to the console
            System.out.println("Error occurred: " + e);
        }
        // Return the ResultSet object to the caller
        return rs;
    }

    // Define a method called "updateDatabase" that takes a query string as a parameter and throws an SQLException
    public void updateDatabase(String query) throws SQLException {
        // Execute the SQL query specified in the query parameter using the executeUpdate method of the Statement object
        stmt.executeUpdate(query);
    }

    // Define a method called "getConn" that returns the conn field
    public Connection getConn() {
        return conn;
    }

}
