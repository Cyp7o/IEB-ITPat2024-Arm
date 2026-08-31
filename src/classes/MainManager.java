// Define the package that this class belongs to
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

// Class to manage tenant information
public class MainManager {

    private ConnectDB db; // Database connection object
    private Main[] Tarr = new Main[200]; // Array to hold tenant data
    private int size = 0; // Current number of tenants in the array

    // Constructor to initialize the MainManager and load tenant data from the database
    public MainManager() {
        try {
            db = new ConnectDB(); // Initialize the database connection
            String sql = "SELECT t.TenantID, t.FirstName, t.Surname, " +
                         "p.Complex, p.UnitNo, p.Address, p.Rent, " +
                         "p.Rent - IIf(SUM(pm.Amount) IS NULL, 0, SUM(pm.Amount)) AS OutstandingBalance, " +
                         "MAX(pm.Datecreated) AS LastPaymentDate " +
                         "FROM (Properties AS p " +
                         "INNER JOIN Tenants AS t ON p.PropertyID = t.PropertyID) " +
                         "LEFT JOIN Payments AS pm ON t.TenantID = pm.TenantID " +
                         "GROUP BY t.TenantID, t.FirstName, t.Surname, " +
                         "p.Complex, p.UnitNo, p.Address, p.Rent";

            // Execute the SQL query and retrieve the results
            ResultSet rs = db.getResults(sql);
            while (rs.next()) {
                java.sql.Date lastPaymentdatesql = rs.getDate("LastPaymentDate");
                LocalDate lastPaymentdate = lastPaymentdatesql != null ? lastPaymentdatesql.toLocalDate() : null;

                // Create a Main object with the tenant data
                Main main = new Main(
                        rs.getInt("TenantID"),
                        rs.getString("FirstName"),
                        rs.getString("Surname"),
                        rs.getString("Complex"),
                        rs.getString("UnitNo"),
                        rs.getString("Address"),
                        rs.getDouble("Rent"),
                        rs.getDouble("OutstandingBalance"),
                        lastPaymentdate);

                // Add the Main object to the array
                Tarr[size++] = main;
            }
        } catch (SQLException ex) {
            // Log any SQL exceptions that occur
            Logger.getLogger(MainManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add tenant data to a table model
    public void addDataToTable(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing rows in the model
        for (int i = 0; i < size; i++) {
            Main tenant = Tarr[i];
            // Add a new row for each tenant
            model.addRow(new Object[]{
                tenant.getTenantID(),
                tenant.getFirstName(),
                tenant.getSurname(),
                tenant.getComplex(),
                tenant.getUnitNo(),
                tenant.getAddress(),
                tenant.getRent(),
                tenant.getOutstandingBalance(),
                tenant.getLastPaymentDate()
            });
        }
    }

  
    // Method to sort the table based on the selected option
    public void sortTable(javax.swing.JTable tblTenants, String selectedOption) {
        DefaultTableModel model = (DefaultTableModel) tblTenants.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblTenants.setRowSorter(tableRowSorter);

        switch (selectedOption) {
            case "Default":
                tableRowSorter.setSortKeys(null); // No sorting
                break;
            case "Paid":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
                break;
            case "Unpaid":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.DESCENDING)));
                break;
            case "Firstname (Z to A)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
                break;
            case "Firstname (A to Z)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                break;
            case "Surname (A to Z)":
              tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
                break;
            case "Surname (Z to A)":
            tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
                break;
            default:
                break;
        }
    }
}

