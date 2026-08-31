// Define the package that this class belongs to
package classes;

// Import the required classes
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

// Define the PaymentManager class
public class PaymentManager {

    // Define private fields for the PaymentManager class
    private ConnectDB db; // An instance of the ConnectDB class for managing database connections
    private Payment[] paymentsArray = new Payment[200]; // An array to store Payment objects
    private int size = 0; // A counter to track the number of Payment objects
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the date format used for parsing dates

    // Constructor for the PaymentManager class
    public PaymentManager() {
        try {
            // Initialize the database connection
            db = new ConnectDB();
            String sql = "SELECT * FROM Payments"; // SQL query to retrieve all payments
            ResultSet rs = db.getResults(sql); // Execute the query and get the ResultSet

            // Process each row in the ResultSet
            while (rs.next()) {
                // Retrieve the date from the ResultSet and convert it to LocalDate
                java.sql.Date dateCreatedSql = rs.getDate("DateCreated");
                LocalDate dateCreated = dateCreatedSql.toLocalDate();

                // Create a new Payment object and store it in the array
                paymentsArray[size] = new Payment(rs.getInt("PaymentID"), rs.getInt("TenantID"), rs.getDouble("Amount"), rs.getString("Invoice"), dateCreated);
                size++;
            }
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to retrieve tenant names (First Name + Surname) from the database
    public ArrayList<String> getTenantNames() {
        ArrayList<String> tenantNames = new ArrayList<>();
        String sql = "SELECT FirstName, Surname FROM Tenants";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Process each row in the ResultSet
            while (rs.next()) {
                // Concatenate FirstName and Surname to form the full name
                String fullName = rs.getString("FirstName") + " " + rs.getString("Surname");
                tenantNames.add(fullName); // Add the full name to the list
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenantNames; // Return the list of tenant names
    }

    // Method to get tenant ID based on the tenant's full name
    public int getTenantIDByName(String fullName) {
        int tenantID = -1; // Default value if tenant ID is not found
        String sql = "SELECT TenantID FROM Tenants WHERE CONCAT(FirstName, ' ', Surname) = ?";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, fullName);
            ResultSet rs = ps.executeQuery();
            // If a result is found, retrieve the tenant ID
            if (rs.next()) {
                tenantID = rs.getInt("TenantID");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenantID; // Return the tenant ID
    }

    // Method to add payments data to a DefaultTableModel for display in a table
    public void addDataToTable(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing data from the table
        // Add each payment object as a row in the table model
        for (int i = 0; i < size; i++) {
            Payment payment = paymentsArray[i];
            model.addRow(new Object[]{payment.getPaymentID(), payment.getTenantID(), payment.getAmount(), payment.getInvoiceNo(), payment.getDateCreated()});
        }
    }

    // Method to add searched payments data to a DefaultTableModel based on a WHERE clause
    public void addSearchedDataToTable(DefaultTableModel model, String where, Object... search) {
        try {
            model.setRowCount(0); // Clear existing data from the table
            String sql = "SELECT * FROM Payments " + where; // Construct SQL query with WHERE clause
            PreparedStatement ps = db.getConn().prepareStatement(sql);

            // Set the values for the PreparedStatement parameters
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }

            ResultSet rs = ps.executeQuery(); // Execute the query
            // Process each row in the ResultSet
            while (rs.next()) {
                // Retrieve the date from the ResultSet and convert it to LocalDate
                java.sql.Date dateCreatedSql = rs.getDate("DateCreated");
                LocalDate dateCreated = dateCreatedSql.toLocalDate();

                // Add each payment's data as a row in the DefaultTableModel
                model.addRow(new Object[]{rs.getInt("PaymentID"), rs.getInt("TenantID"), rs.getDouble("Amount"), rs.getString("Invoice"), dateCreated});
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add a new payment to the Payments table
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO Payments(TenantID, Amount, Invoice, DateCreated) VALUES(?,?,?,?)"; // SQL query to insert a new payment
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Create PreparedStatement
            ps.setInt(1, payment.getTenantID()); // Set TenantID
            ps.setDouble(2, payment.getAmount()); // Set Amount
            ps.setString(3, payment.getInvoiceNo()); // Set Invoice
            ps.setDate(4, java.sql.Date.valueOf(payment.getDateCreated())); // Set DateCreated
            ps.executeUpdate(); // Execute the PreparedStatement to insert the payment
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to delete a payment from the Payments table based on PaymentID
    public void deletePayment(int paymentID) {
        String sql = "DELETE FROM Payments WHERE PaymentID = ?"; // SQL query to delete a payment
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql); // Create PreparedStatement
            ps.setInt(1, paymentID); // Set PaymentID
            ps.executeUpdate(); // Execute the PreparedStatement to delete the payment
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
// Method to generate monthly income report for the current month and year
public double getMonthIncome() {
    double totalIncome = 0.0; // Initialize total income
    
    // Get the current month and year
    LocalDate now = LocalDate.now();
    int currentMonth = now.getMonthValue(); // Get the current month (1-12)
    int currentYear = now.getYear(); // Get the current year (e.g., 2024)
    
    // SQL query to sum payments for the current month and year
    // Convert text to date using CDate and extract month and year
    String sql = "SELECT SUM(Amount) AS TotalIncome FROM Payments " +
                 "WHERE Month(CDate(DateCreated)) = ? AND Year(CDate(DateCreated)) = ?";
    
    try {
        // Prepare and execute the SQL query
        try (PreparedStatement ps = db.getConn().prepareStatement(sql)) {
            ps.setInt(1, currentMonth); // Set the current month
            ps.setInt(2, currentYear); // Set the current year
            
            // Retrieve the total income from the result set
            try (ResultSet rs = ps.executeQuery()) {
                // Retrieve the total income from the result set
                if (rs.next()) {
                    totalIncome = rs.getDouble("TotalIncome");
                }
            }
        }
    } catch (SQLException ex) {
        // Log any SQL exceptions
        Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, "Error executing SQL query", ex);
    }
    
    return totalIncome; // Return the total income
}
public void generateMonthlyPaymentsReportAndDelete() throws FileNotFoundException {
    // Get the current date
    LocalDate now = LocalDate.now();
    
    // Calculate the first day of the current month and subtract one month to get the previous month
    LocalDate firstDayOfCurrentMonth = now.withDayOfMonth(1);
    LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
    
    // Format the previous month and year
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM"); // Full month name
    DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy"); // Year
    String previousMonthName = firstDayOfPreviousMonth.format(monthFormatter);
    String previousYear = firstDayOfPreviousMonth.format(yearFormatter);

    // Define the folder path and file name
    String folderPath = "Reports";
    String fileName = "payments_" + previousMonthName + "_" + previousYear + ".txt";
    File folder = new File(folderPath);

    // Create the folder if it does not exist
    if (!folder.exists()) {
        folder.mkdirs();
    }

    File file = new File(folder, fileName);

    try (PrintWriter writer = new PrintWriter(file)) {
        writer.println("Payments Report for " + previousMonthName + " " + previousYear);
        writer.println("---------------------------------------------------");
        writer.println("PaymentID\tTenantID\tAmount\tInvoice\tDateCreated");
        writer.println("---------------------------------------------------");

        // SQL query to get payments for the previous month using text comparison
        String sql = "SELECT * FROM Payments WHERE DateCreated LIKE ?";
       // System.out.println("Executing SQL query: " + sql + " with pattern: " + previousYear + "-" + String.format("%02d", firstDayOfPreviousMonth.getMonthValue()) + "%");
        try (PreparedStatement ps = db.getConn().prepareStatement(sql)) {
            ps.setString(1, previousYear + "-" + String.format("%02d", firstDayOfPreviousMonth.getMonthValue()) + "%"); // Match year and month
            
            try (ResultSet rs = ps.executeQuery()) {
                boolean recordsFound = false;
                // Process each row in the ResultSet
                while (rs.next()) {
                    recordsFound = true;
                    // Retrieve data from the ResultSet
                    int paymentID = rs.getInt("PaymentID");
                    int tenantID = rs.getInt("TenantID");
                    double amount = rs.getDouble("Amount");
                    String invoice = rs.getString("Invoice");
                    String dateCreatedStr = rs.getString("DateCreated");

                    // Write each payment's data as a row in the text file
                    writer.println(paymentID + "\t" + tenantID + "\t" + String.format("%.2f", amount) + "\t" + invoice + "\t" + dateCreatedStr);

                    // Delete the payment from the database
                    deletePayment(paymentID);
                }
                
                if (!recordsFound) {
                    writer.println("No records found for pattern: " + previousYear + "-" + String.format("%02d", firstDayOfPreviousMonth.getMonthValue()) + "%");
                }
            }
        }

    } catch (SQLException ex) {
        // Log any SQL exceptions that occur
        Logger.getLogger(PaymentManager.class.getName()).log(Level.SEVERE, "SQL Error", ex);
    }
}
}