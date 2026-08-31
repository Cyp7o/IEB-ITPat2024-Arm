// Define the package that this class belongs to
package classes;

// Import the required classes
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

// DataValidation class
public class DataValidation {

    private boolean valid; // a boolean variable to store if the data is valid or not
    private ConnectDB db; // an instance of the ConnectDB class for database operations

    // Constructor: Initializes the DataValidation object and ConnectDB object
    public DataValidation() {
        valid = true; // initialize valid to true
        db = new ConnectDB(); // create a new ConnectDB object
    }

    // Getter method for valid
    public boolean isValid() {
        return valid; // return the value of valid
    }

    // Method to check the validity of the Company name
    public String checkCompany(String company) {
        // Param: company (String) - The Company name to be validated

        // Presence Check: checks if the company name is not empty
        if (company.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the company name."; // return error message
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the invoice number
    public String checkInvoice(String invoiceNo) {
        // Presence Check: checks if the invoice number is not empty
        if (invoiceNo.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the invoice number."; // return error message
        }
        // Format Check: checks that the invoice number starts with a '#'
        else if (!invoiceNo.startsWith("#")) {
            valid = false; // if it doesn't start with '#', set valid to false
            return "Invoice number must start with '#'.";
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the amount
    public String checkAmount(String amountText) {
        // Param: amountText (String) - The amount to be validated as a string

        // Presence Check: checks if the amount text is not empty
        if (amountText.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter an amount."; // return error message
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the payment date
    public String checkPaymentDate(LocalDate paymentdate) {
        // Param: paymentdate (LocalDate) - The payment date to be validated

        LocalDate now = LocalDate.now(); // Get the current date
        // Check if the payment date is within the current month
        if (paymentdate.getMonthValue() != now.getMonthValue() || paymentdate.getYear() != now.getYear()) {
            valid = false; // if the payment date is not within the current month, set valid to false
            return "Payments can only be made in the current month.";
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the unit number
    public String checkUnitNo(String unitno) {
        // Param: unitno (String) - The unit number to be validated

        // Presence Check: checks if the unit number is not empty
        if (unitno.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the unit number."; // return error message
        }
        try {
            Integer.parseInt(unitno); // Try to parse the unit number to an integer
        } catch (NumberFormatException e) {
            valid = false; // if the unit number is not a valid integer, set valid to false
            return "Unit number must be a valid integer.";
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the complex name
    public String checkComplex(String complex) {
        // Param: complex (String) - The complex name to be validated

        // Presence Check: checks if the complex name is not empty
        if (complex.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the complex name."; // return error message
        }
        // Check if the complex name starts with a capital letter
        else if (!Character.isUpperCase(complex.charAt(0))) {
            valid = false; // if it does not start with a capital letter, set valid to false
            return "Complex name must start with a capital letter.";
        }
        // Check if the complex name contains only letters and spaces
        else if (!complex.matches("[A-Za-z ]+")) {
            valid = false; // if the complex name contains special characters or numbers, set valid to false
            return "Complex name must not contain special characters or numbers.";
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the property address
    public String checkAddress(String address) {
        // Param: address (String) - The property address to be validated

        // Presence Check: checks if the address is not empty
        if (address.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the property address."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the suburb
    public String checkSuburb(String suburb) {
        // Param: suburb (String) - The suburb to be validated

        // Presence Check: checks if the suburb is not empty
        if (suburb.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the suburb."; // return error message
        }
        // Format Check: checks if the suburb contains numbers
        if (suburb.matches(".*\\d+.*")) {
            valid = false; // if it contains numbers, set valid to false
            return "Suburb cannot contain numbers."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the property category
    public String checkCategory(String category) {
        // Param: category (String) - The category to be validated

        // Presence Check: checks if the category is not empty
        if (category.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the Category type."; // return error message
        }
        return null; // Return null if data is valid
    }

    // Method to check the validity of the rent amount
    public String checkRent(String rent) {
        // Param: rent (String) - The rent amount to be validated

        // Format Check: checks if the rent amount contains only numeric characters
        if (!rent.matches("\\d+")) {
            valid = false; // if it contains non-numeric characters, set valid to false
            return "Rent amount must be a valid number."; // return error message
        }

        int rentAmount = Integer.parseInt(rent); // Parse the rent amount to an integer

        // Range Check: checks if the rent amount is greater than 0
        if (rentAmount <= 0) {
            valid = false; // if it's less than or equal to 0, set valid to false
            return "Please enter a valid rent amount."; // return error message
        }

        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the property's image
    public String checkImage(String image) {
        // Param: image (String) - The image of the property to be validated

        // Presence Check: checks if the image is not empty
        if (image == null || image.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please select the property's image"; // return error message
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the first name
    public String checkFirstName(String firstName) {
        // Param: firstName (String) - The first name to be validated

        // Presence Check: checks if the first name is not empty
        if (firstName.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the first name."; // return error message
        }
        // Length Check: checks if the first name is between 2 and 50 characters long
        else if (firstName.length() < 2 || firstName.length() > 50) {
            valid = false; // if it's too short or too long, set valid to false
            return "First name must be between 2 and 50 characters long."; // return error message
        }
        // Format Check: checks if the first name contains only letters
        else if (!firstName.matches("[A-Za-z]+")) {
            valid = false; // if it contains special characters or numbers, set valid to false
            return "First name must contain only letters."; // return error message
        }
        // Capitalization Check: checks if the first name starts with a capital letter
        else if (!Character.isUpperCase(firstName.charAt(0))) {
            valid = false; // if it does not start with a capital letter, set valid to false
            return "First name must start with a capital letter.";
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the last name
    public String checkLastName(String lastName) {
        // Param: lastName (String) - The last name to be validated

        // Presence Check: checks if the last name is not empty
        if (lastName.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter the last name."; // return error message
        }
        // Length Check: checks if the last name is between 2 and 50 characters long
        else if (lastName.length() < 2 || lastName.length() > 50) {
            valid = false; // if it's too short or too long, set valid to false
            return "Last name must be between 2 and 50 characters long."; // return error message
        }
        // Format Check: checks if the last name contains only letters
        else if (!lastName.matches("[A-Za-z]+")) {
            valid = false; // if it contains special characters or numbers, set valid to false
            return "Last name must contain only letters."; // return error message
        }
        // Capitalization Check: checks if the last name starts with a capital letter
        else if (!Character.isUpperCase(lastName.charAt(0))) {
            valid = false; // if it does not start with a capital letter, set valid to false
            return "Last name must start with a capital letter.";
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to check the validity of the middle name
    public String checkMiddleName(String middleName) {
        // Param: middleName (String) - The middle name to be validated

        // Check if the middle name is empty
        if (middleName.isEmpty()) {
            return ""; // Return an empty string if middle name is not provided
        }
        // Length Check: checks if the middle name is between 2 and 50 characters long
        else if (middleName.length() < 2 || middleName.length() > 50) {
            valid = false; // if it's too short or too long, set valid to false
            return "Middle name must be between 2 and 50 characters long."; // return error message
        }
    // Format Check: checks if the middle name contains only letters and is not equal to two invisible characters
else if (!middleName.matches("[A-Za-z]+") && !middleName.equals("\u200B\u200B\u200B")) {
    valid = false; // if it contains special characters or numbers, set valid to false
    return "Middle name must contain only letters."; // return error message
}

// Capitalization Check: checks if the middle name starts with a capital letter and is not equal to two invisible characters
else if (!middleName.equals("\u200B\u200B\u200B") && !Character.isUpperCase(middleName.charAt(0))) {
    valid = false; // if it does not start with a capital letter, set valid to false
    return "Middle name must start with a capital letter.";
}
    return "";
    }

    // Method to validate the ID number
    public String checkId(String id) {
        // Param: id (String) - The ID number to be validated

        // Presence Check: checks if the ID is not empty
        if (id.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter an ID number."; // return error message
        }
        // Format Check: checks if the ID is numeric and 13 characters long
        else if (!id.matches("\\d{13}")) {
            valid = false; // if it's not numeric or not 13 characters long, set valid to false
            return "ID number must be exactly 13 digits."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to validate the date of birth
    public String checkDOB(String dobText) {
        // Param: dobText (String) - The date of birth to be validated as a string
        try {
            LocalDate dob = LocalDate.parse(dobText); // Parse the date of birth from the string
            LocalDate now = LocalDate.now(); // Get the current date
            // Calculate the age
            int age = Period.between(dob, now).getYears();
            // Check if the age is at least 18
            if (age < 18) {
                valid = false; // if the age is less than 18, set valid to false
                return "You must be at least 18 years old."; // return error message
            }
        } catch (Exception e) {
            valid = false; // if parsing fails, set valid to false
            return "Invalid date of birth format. Use YYYY-MM-DD."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }
  public String  checkLeaseStartDate(String leaseStartDatetext) {
        // Param: dobText (String) - The date of birth to be validated as a string

    
      // Define the date format expected in the string
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    try {
        // Parse the string to a LocalDate object
        LocalDate startDate = LocalDate.parse(leaseStartDatetext, formatter);

        // Get the current date
        LocalDate now = LocalDate.now();

        // Check if the lease start date is in the future
        if (startDate.isAfter(now)) {
            return "The lease start date cannot be in the future."; // Return error message
        }

        } catch (Exception e) {
            valid = false; // if parsing fails, set valid to false
            return "Invalid date of birth format. Use YYYY-MM-DD."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }
    // Method to validate the phone number
    public String checkPhone(String phone) {
        // Param: phone (String) - The phone number to be validated

        // Check if the phone number is empty
        if (phone.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter a phone number."; // return error message
        }
        // Format Check: checks if the phone number is numeric and exactly 10 digits long
        else if (!phone.matches("\\d{10}")) {
            valid = false; // if it's not numeric or not 10 digits long, set valid to false
            return "Phone number must be exactly 10 digits."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }

    // Method to validate the email address
    public String checkEmail(String email) {
        // Param: email (String) - The email address to be validated

        // Check if the email address is empty
        if (email.isEmpty()) {
            valid = false; // if it's empty, set valid to false
            return "Please enter an email address."; // return error message
        }
        // Format Check: uses a regular expression to check if the email format is valid
        else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            valid = false; // if it does not match the regular expression, set valid to false
            return "Invalid email format."; // return error message
        }
        return ""; // Return an empty string if data is valid
    }
        // Method to check if a payment with the same PaymentID already exists
    public boolean paymentExists(int paymentID) {
        // Param: paymentID (int) - The ID of the payment to check

        // SQL Query to check if a payment with the given PaymentID exists
        String query = "SELECT COUNT(*) FROM Payments WHERE PaymentID = ?";

        try {
            // Prepare the SQL statement
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setInt(1, paymentID); // Set the paymentID parameter

            ResultSet rs = ps.executeQuery(); // Execute the query
            if (rs.next()) {
                int count = rs.getInt(1); // Get the count result
                return count > 0; // Return true if count is greater than 0
            }

            // Close resources
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DataValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; // Return false if paymentID does not exist
    }

    // Method to check if an expense with the same InvoiceNo already exists
    public boolean expenseExists(String invoiceNo, int expenseID) {
        // Param: invoiceNo (String) - The invoice number to check
        // Param: expenseID (int) - The ID of the expense to be excluded from the check

        // SQL Query to check if an expense with the given invoiceNo exists (excluding the current expense)
        String query = "SELECT COUNT(*) FROM Expenses WHERE InvoiceNo = ? AND ExpenseID <> ?";

        try {
            // Prepare the SQL statement
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, invoiceNo); // Set the invoiceNo parameter
            ps.setInt(2, expenseID); // Set the expenseID parameter

            ResultSet rs = ps.executeQuery(); // Execute the query
            if (rs.next()) {
                int count = rs.getInt(1); // Get the count result
                return count > 0; // Return true if count is greater than 0
            }

            // Close resources
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DataValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; // Return false if invoiceNo does not exist
    }

    // Method to check if a tenant with the same email already exists
    public boolean tenantExists(String email, int tenantID) {
        // Param: email (String) - The email address to check
        // Param: tenantID (int) - The ID of the tenant to be excluded from the check

        // SQL query to check if a tenant with the given email exists, excluding the current tenant
        String query = "SELECT COUNT(*) FROM Tenants WHERE Email = ? AND TenantID <> ?";

        try {
            // Prepare the SQL statement
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, email); // Set the email parameter
            ps.setInt(2, tenantID); // Set the tenantID parameter

            ResultSet rs = ps.executeQuery(); // Execute the query
            if (rs.next()) {
                int count = rs.getInt(1); // Get the count result
                return count > 0; // Return true if count is greater than 0
            }

            // Close resources
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DataValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; // Return false if email does not exist
    }

    // Method to check if a property with the same address and suburb already exists
    public boolean propertyExists(String address, String suburb, int propertyID) {
        // Param: address (String) - The address of the property to check
        // Param: suburb (String) - The suburb of the property to check
        // Param: propertyID (int) - The ID of the property to be excluded from the check

        // SQL Query to check if a property with the given address and suburb exists (excluding the current property)
        String query = "SELECT COUNT(*) FROM Properties WHERE Address = ? AND Suburb = ? AND PropertyID <> ?";

        try {
            // Prepare the SQL statement
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, address); // Set the address parameter
            ps.setString(2, suburb); // Set the suburb parameter
            ps.setInt(3, propertyID); // Set the propertyID parameter

            ResultSet rs = ps.executeQuery(); // Execute the query
            if (rs.next()) {
                int count = rs.getInt(1); // Get the count result
                return count > 0; // Return true if count is greater than 0
            }

            // Close resources
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DataValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; // Return false if property does not exist
    }
}



