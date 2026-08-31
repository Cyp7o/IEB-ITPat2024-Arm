package classes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TenantManager {

    private ConnectDB db; // Database connection object
    private Tenant[] tArr = new Tenant[200]; // Array to store Tenant objects
    private int size = 0; // Current number of tenants in the array

    // Constructor: initializes the database connection and loads tenants data
    public TenantManager() {
        try {
            db = new ConnectDB();
            String sql = "SELECT * FROM Tenants";
            ResultSet rs = db.getResults(sql);
            while (rs.next()) {
                // Convert SQL Date to LocalDate
                java.sql.Date dobSql = rs.getDate("DOB");
                LocalDate dob = dobSql.toLocalDate();

                java.sql.Date leaseStartDateSql = rs.getDate("LeaseStartDate");
                LocalDate leaseStartDate = leaseStartDateSql.toLocalDate();

                // Create Tenant object and add to the array
                tArr[size] = new Tenant(
                        rs.getInt("TenantID"),
                        rs.getString("FirstName"),
                        rs.getString("MiddelName"),
                        rs.getString("Surname"),
                        rs.getInt("PropertyID"),
                        leaseStartDate,
                        dob,
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"));
                        
                size++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to get a list of property IDs that are not occupied
    public ArrayList<Integer> getPropertyIDs() {
        ArrayList<Integer> propertyIDs = new ArrayList<>();
        String sql = "SELECT PropertyID FROM Properties WHERE Occupied = False"; 

        try {
            ResultSet rs = db.getResults(sql);
            while (rs.next()) {
                int propertyID = rs.getInt("PropertyID");
                propertyIDs.add(propertyID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return propertyIDs;
    }

    // Method to get a list of property IDs that are currently assigned to tenants
    public ArrayList<Integer> getPropertyIDsFromTenants() {
        ArrayList<Integer> PropertyIDsFromTenants = new ArrayList<>();
        String sql = "SELECT DISTINCT PropertyID FROM Tenants";
        try {
            ResultSet rs = db.getResults(sql);
            while (rs.next()) {
                int propertyID = rs.getInt("PropertyID");
                PropertyIDsFromTenants.add(propertyID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PropertyIDsFromTenants;
    }

    // Method to add tenant data to the provided table model
    public void addDataToTable(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing rows
        for (int i = 0; i < size; i++) {
            model.addRow(new Object[]{
                tArr[i].getTenantID(),
                tArr[i].getFirstName(),
                tArr[i].getMiddleName(),
                tArr[i].getSurname(),
                tArr[i].getPropertyID(),
                tArr[i].getLeaseStartDate(),
                tArr[i].getDob(),
                tArr[i].getEmail(),
                tArr[i].getPhoneNumber()
            });
        }
    }

    // Method to retrieve a tenant based on propertyID
    public Tenant getTenant(int propertyID) {
        String sql = "SELECT Firstname, MiddelName, Surname, DOB, Email FROM Tenants WHERE PropertyID = ?";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, propertyID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Tenant(
                    rs.getString("Firstname"),
                    rs.getString("Surname"),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getString("Email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Method to add searched tenant data to the provided table model based on criteria
    public void addSearchedDataToTable(DefaultTableModel model, String where, Object... search) {
        try {
            model.setRowCount(0); // Clear existing rows
            String sql = "SELECT * FROM Tenants " + where;
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("TenantID"),
                    rs.getString("FirstName"),
                    rs.getString("MiddelName"),
                    rs.getString("Surname"),
                    rs.getInt("PropertyID"),
                    rs.getDate("LeaseStartDate").toLocalDate(),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getString("Email"),
                    rs.getString("PhoneNumber")
                });
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to add a new tenant to the database
    public void addTenant(Tenant tenant) {
        String sql = "INSERT INTO Tenants(FirstName, MiddelName, Surname, PropertyID, LeaseStartDate, DOB, Email, PhoneNumber) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, tenant.getFirstName());
            ps.setString(2, tenant.getMiddleName());
            ps.setString(3, tenant.getSurname());
            ps.setInt(4, tenant.getPropertyID());
            ps.setDate(5, Date.valueOf(tenant.getLeaseStartDate()));
            ps.setDate(6, Date.valueOf(tenant.getDob()));
            ps.setString(7, tenant.getEmail());
            ps.setString(8, tenant.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to delete a tenant based on tenantID
    public void deleteTenant(int tenantID) {
        String sql = "DELETE FROM Tenants WHERE TenantID = ?";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, tenantID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to edit an existing tenant's details
    public void editTenant(Tenant tenant) {
        String sql = "UPDATE Tenants SET FirstName = ?, MiddelName = ?, Surname = ?, PropertyID = ?, LeaseStartDate = ?, DOB = ?, Email = ?, PhoneNumber = ? WHERE TenantID = ?";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, tenant.getFirstName());
            ps.setString(2, tenant.getMiddleName());
            ps.setString(3, tenant.getSurname());
            ps.setInt(4, tenant.getPropertyID());
            ps.setDate(5, Date.valueOf(tenant.getLeaseStartDate()));
            ps.setDate(6, Date.valueOf(tenant.getDob()));
            ps.setString(7, tenant.getEmail());
            ps.setString(8, tenant.getPhoneNumber());
            ps.setInt(9, tenant.getTenantID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to sort the tenant table based on the selected option
    public void sortTable(JTable tblTenants, String selectedOption) {
        DefaultTableModel model = (DefaultTableModel) tblTenants.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblTenants.setRowSorter(tableRowSorter);
        switch (selectedOption) {
            case "Default":
                tableRowSorter.setSortKeys(null);
                break;
            case "Oldest to Youngest":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
                break;
            case "Youngest to Oldest":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.DESCENDING)));
                break;
            case "Firstname (Z to A)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
                break;
            case "Firstname (A to Z)":
                tableRowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                break;
            case "Surname (A to Z)":
                filterTableBySurnameAscending(tblTenants);
                break;
            case "Surname (Z to A)":
                filterTableBySurnameDescending(tblTenants);
                break;
            default:
                break;
        }
    }

    // Helper method to sort table by surname in ascending order
    private void filterTableBySurnameAscending(JTable tblTenants) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblTenants.getModel());
        tblTenants.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    // Helper method to sort table by surname in descending order
    private void filterTableBySurnameDescending(JTable tblTenants) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblTenants.getModel());
        tblTenants.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    // Method to check if a tenant has an active rental
    public boolean hasRental(int tenantID) {
        String sql = "SELECT COUNT(*) FROM Tenants WHERE TenantID = ? AND TenantID IN (SELECT TenantID FROM Rentals)";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, tenantID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Method to get the total number of tenant entries
    public int getTotalEntries() {
        String sql = "SELECT COUNT(*) FROM Tenants";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // Return 0 if there is an error or no entries found
    }
}
