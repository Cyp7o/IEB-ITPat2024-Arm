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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

// Define the ExpenseManager class
public class ExpenseManager {

    // Define private fields for the ExpenseManager class
    private ConnectDB db; // An instance of the ConnectDB class for database connection
    private Expense[] eArr = new Expense[200]; // An array to store Expense objects
    private int size = 0; // A counter to keep track of the number of expenses
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the date format

    // Define a constructor for the ExpenseManager class
    public ExpenseManager() {
        try {
            // Initialize the database connection
            db = new ConnectDB();
            // SQL query to select all rows from the Expenses table
            String sql = "SELECT * FROM Expenses";
            // Execute the query and get the ResultSet
            ResultSet rs = db.getResults(sql);
            // Iterate through the ResultSet and populate the eArr array with Expense objects
            while (rs.next()) {
                java.sql.Date paymentdateSql = rs.getDate("PaymentDate");
                LocalDate paymentdate = paymentdateSql.toLocalDate();
                eArr[size] = new Expense(rs.getInt("ExpenseID"), paymentdate, rs.getString("Details"),
                        rs.getString("InvoiceNo"), rs.getString("Company"), rs.getDouble("Amount"));
                size++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Method to create a monthly report file and delete records
    public void generateMonthlyReportAndDelete() {
        // Get the current date and the first day of the current month
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = now.withDayOfMonth(1);
        // Get the first day of the previous month
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
        String previousMonthName = firstDayOfPreviousMonth.format(monthFormatter);
        String previousYear = firstDayOfPreviousMonth.format(DateTimeFormatter.ofPattern("yyyy"));
        String folderPath = "Reports";
        String fileName = "expenses_" + previousMonthName + "_" + previousYear + ".txt";
        File folder = new File(folderPath);

        // Create the folder if it does not exist
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder, fileName);

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Expenses Report for " + previousMonthName + " " + previousYear);
            writer.println("---------------------------------------------------");
            writer.println("ExpenseID\tPaymentDate\tDetails\tInvoiceNo\tCompany\tAmount");
            writer.println("---------------------------------------------------");

            // SQL query to get expenses for the previous month
            String sql = "SELECT * FROM Expenses WHERE PaymentDate LIKE ?";
            try (PreparedStatement ps = db.getConn().prepareStatement(sql)) {
                ps.setString(1, previousYear + "-" + String.format("%02d", firstDayOfPreviousMonth.getMonthValue()) + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    boolean recordsFound = false;
                    // Iterate through the ResultSet and write the data to the file
                    while (rs.next()) {
                        recordsFound = true;
                        int expenseID = rs.getInt("ExpenseID");
                        LocalDate paymentDate = rs.getDate("PaymentDate").toLocalDate();
                        String details = rs.getString("Details");
                        String invoiceNo = rs.getString("InvoiceNo");
                        String company = rs.getString("Company");
                        double amount = rs.getDouble("Amount");

                        writer.printf("%d\t%s\t%s\t%s\t%s\t%.2f%n", expenseID, paymentDate, details, invoiceNo, company, amount);

                        // Delete the expense from the database
                        deleteExpense(expenseID);
                    }
                    if (!recordsFound) {
                        writer.println("No records found for pattern: " + previousYear + "-" + String.format("%02d", firstDayOfPreviousMonth.getMonthValue()) + "%");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add data to a table model
    public void addDataToTable(DefaultTableModel model) {
        // Clear the existing rows in the table model
        model.setRowCount(0);
        // Iterate through the eArr array and add the data to the table model
        for (int i = 0; i < size; i++) {
            model.addRow(new Object[]{
                eArr[i].getExpenseID(),
                eArr[i].getPaymentDate(),
                eArr[i].getDetails(),
                eArr[i].getInvoiceNo(),
                eArr[i].getCompany(),
                eArr[i].getAmount()
            });
        }
    }

    // Method to add searched data to a table model
    public void addSearchedDataToTable(DefaultTableModel model, String where, Object... search) {
        try {
            // Clear the existing rows in the table model
            model.setRowCount(0);
            // Prepare the SQL query with the search criteria
            String sql = "SELECT * FROM Expenses " + where;
            PreparedStatement ps = db.getConn().prepareStatement(sql);

            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }

            // Execute the query and get the ResultSet
            ResultSet rs = ps.executeQuery();

            // Iterate through the ResultSet and add the data to the table model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("ExpenseID"),
                    rs.getDate("PaymentDate").toLocalDate(),
                    rs.getString("Details"),
                    rs.getString("Company"),
                    rs.getString("InvoiceNo"),
                    rs.getDouble("Amount")
                });
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add an Expense object to the database
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO Expenses(Details, InvoiceNo, Company, PaymentDate, Amount) VALUES(?,?,?,?,?)";
        try {
            // Prepare the SQL query with the expense data
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, expense.getDetails());
            ps.setString(2, expense.getInvoiceNo());
            ps.setString(3, expense.getCompany());
            ps.setString(4, expense.getPaymentDate());
            ps.setDouble(5, expense.getAmount());
            // Execute the query to insert the expense data
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to delete an expense from the database
    public void deleteExpense(int expenseID) {
        String sql = "DELETE FROM Expenses WHERE ExpenseID = ?";
        try {
            // Prepare the SQL query with the expense ID
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, expenseID);
            // Execute the query to delete the expense
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to update an existing expense in the database
    public void editExpense(Expense expense) {
        String sql = "UPDATE Expenses SET PaymentDate = ?, Details = ?, Company = ?, InvoiceNo = ?, Amount = ? WHERE ExpenseID = ?";
        try {
            // Prepare the SQL query with the updated expense data
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, expense.getPaymentDate());
            ps.setString(2, expense.getDetails());
            ps.setString(3, expense.getCompany());
            ps.setString(4, expense.getInvoiceNo());
            ps.setDouble(5, expense.getAmount());
            ps.setInt(6, expense.getExpenseID());
            // Execute the query to update the expense
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Private method to filter table by details in ascending order
    private void filterTableByDetailsAscending(javax.swing.JTable tblExpenses) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblExpenses.getModel());
        tblExpenses.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    // Private method to filter table by details in descending order
    private void filterTableByDetailsDescending(javax.swing.JTable tblExpenses) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblExpenses.getModel());
        tblExpenses.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    // Public method to sort the table based on the selected option
    public void sortTable(javax.swing.JTable tblExpenses, String selectedOption) {
        DefaultTableModel model = (DefaultTableModel) tblExpenses.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblExpenses.setRowSorter(tableRowSorter);

        // Switch case to handle the different sorting options
        switch (selectedOption) {
            case "Default":
                tableRowSorter.setSortKeys(null);
                break;
            case "Date (Oldest to Newest)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                break;
            case "Date (Newest to Oldest)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
                break;
            case "Details (A to Z)":
                filterTableByDetailsAscending(tblExpenses);
                break;
            case "Details (Z to A)":
                filterTableByDetailsDescending(tblExpenses);
                break;
            default:
                break;
        }
    }
     // Method to calculate the total amount for the current month and year
    public double calculateMonthlyTotal() {
        double totalAmount = 0.0;
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();
        for (int i = 0; i < size; i++) {
            LocalDate paymentDate = LocalDate.parse(eArr[i].getPaymentDate(), formatter); // Parse the date string
            if (paymentDate.getMonthValue() == currentMonth && paymentDate.getYear() == currentYear) {
                totalAmount += eArr[i].getAmount();
            }
        }
        return totalAmount;
    }

    public  double getCurrentMonthTotal() {
        return calculateMonthlyTotal();
    }
}
