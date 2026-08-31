// Define the package that this class belongs to
package classes;

import java.time.LocalDate;

// Define the Main class to represent a tenant's information
public class Main {
    private final int tenantID; // Unique identifier for the tenant
    private String firstName; // Tenant's first name
    private String surname; // Tenant's surname
    private String unitNo; // Unit number where the tenant resides
    private String address; // Tenant's address
    private double rent; // Monthly rent amount
    private double outstandingBalance; // Amount of rent that is outstanding
    private LocalDate lastPaymentDate; // Date of the last payment made by the tenant
    private String complex; // Name of the complex where the unit is located

    // Constructor to initialize a new tenant object
    public Main(int tenantID, String firstName, String surname, String complex, String unitNo, String address, double rent, double outstandingBalance, LocalDate lastPaymentDate) {
        this.tenantID = tenantID; // Initialize tenant ID
        this.firstName = firstName; // Initialize first name
        this.surname = surname; // Initialize surname
        this.unitNo = unitNo; // Initialize unit number
        this.address = address; // Initialize address
        this.rent = rent; // Initialize rent amount
        this.outstandingBalance = outstandingBalance; // Initialize outstanding balance
        this.lastPaymentDate = lastPaymentDate; // Initialize last payment date
        this.complex = complex; // Initialize complex name
    }

    // Getter for tenant ID
    public int getTenantID() {
        return tenantID;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for surname
    public String getSurname() {
        return surname;
    }

    // Setter for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter for unit number
    public String getUnitNo() {
        return unitNo;
    }

    // Setter for unit number
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for rent amount
    public double getRent() {
        return rent;
    }

    // Setter for rent amount
    public void setRent(double rent) {
        this.rent = rent;
    }

    // Getter for outstanding balance
    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    // Setter for outstanding balance
    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    // Getter for last payment date
    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    // Setter for last payment date
    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    // Getter for complex name
    public String getComplex() {
        return complex;
    }

    // Setter for complex name
    public void setComplex(String complex) {
        this.complex = complex;
    }
}
