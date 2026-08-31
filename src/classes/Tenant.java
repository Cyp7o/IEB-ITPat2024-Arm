package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tenant {
    // Instance variables
    private int tenantID; // Unique identifier for the tenant
    private String firstName; // First name of the tenant
    private String middleName; // Middle name of the tenant (optional)
    private String surname; // Surname of the tenant
    private int propertyID; // Unique identifier for the property the tenant is renting
    private LocalDate leaseStartDate; // Start date of the tenant's lease
    private LocalDate dob; // Date of birth of the tenant
    private String email; // Email address of the tenant
    private String PhoneNumber; // Phone number of the tenant

    // Constructor to initialize all fields
    public Tenant(int tenantID, String firstName, String middleName, String surname, int propertyID, LocalDate leaseStartDate, LocalDate dob, String email, String PhoneNumber) {
        this.tenantID = tenantID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.propertyID = propertyID;
        this.leaseStartDate = leaseStartDate;
        this.dob = dob;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }

    // Constructor to initialize all fields except tenantID
    public Tenant(String firstName, String middleName, String surname, int propertyId, LocalDate leaseStartDate, LocalDate dob, String email, String PhoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.propertyID = propertyId;
        this.leaseStartDate = leaseStartDate;
        this.dob = dob;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }

    // Constructor to initialize only the essential fields for tenant creation
    public Tenant(String firstname, String surname, LocalDate dob, String email) {
        this.firstName = firstname;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
    }

    // Getter for tenantID
    public int getTenantID() {
        return tenantID;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for middleName
    public String getMiddleName() {
        return middleName;
    }

    // Getter for surname
    public String getSurname() {
        return surname;
    }

    // Getter for propertyID
    public int getPropertyID() {
        return propertyID;
    }

    // Alternative getter for propertyID, may be redundant
    public int getPropertyIDsFromTenants() {
        return propertyID;
    }

    // Getter for leaseStartDate formatted as a String
    public String getLeaseStartDate() {
        return leaseStartDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Getter for dob formatted as a String
    public String getDob() {
        return dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Setter for middleName
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Setter for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Setter for propertyID
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    // Setter for leaseStartDate
    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    // Setter for dob
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for PhoneNumber
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
}
