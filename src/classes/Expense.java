// Define the package that this class belongs to
package classes;

// Import the required classes from java.time package
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Define the Expense class
public class Expense {

    // Define private fields for the Expense class
    private int ExpenseID; // A unique identifier for the expense
    private LocalDate paymentDate; // The date of the expense payment
    private String details; // Details or description of the expense
    private String company; // The company associated with the expense
    private String invoiceNo; // The invoice number for the expense
    private double amount; // The amount associated with the expense

    // Define a constructor that takes all six fields as parameters
    public Expense(int ExpenseID, LocalDate paymentDate, String details, String company, String invoiceNo, double amount) {
        // Set the values of the object's fields to the values passed in as parameters
        this.ExpenseID = ExpenseID; 
        this.paymentDate = paymentDate;
        this.details = details;
        this.company = company;
        this.invoiceNo = invoiceNo;
        this.amount = amount;
    }

    // Define a constructor that doesn't take an ExpenseID parameter
    public Expense(LocalDate paymentDate, String details, String company, String invoiceNo, double amount) {
        // Set the values of the object's fields to the values passed in as parameters, 
        // but leave the ExpenseID field at its default value (0)
        this.paymentDate = paymentDate;
        this.details = details;
        this.company = company;
        this.invoiceNo = invoiceNo;
        this.amount = amount;
    }

    // Get the Expense ID
    public int getExpenseID() {
        return ExpenseID;
    }

    // Get the date of payment formatted as a String in the "yyyy-MM-dd" format
    public String getPaymentDate() {
        return paymentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Get the details or description of the expense
    public String getDetails() {
        return details;
    }

    // Get the company associated with the expense
    public String getCompany() {
        return company;
    }

    // Get the invoice number for the expense
    public String getInvoiceNo() {
        return invoiceNo;
    }

    // Get the amount associated with the expense
    public double getAmount() {
        return amount;
    }

    // Set the Expense ID
    public void setExpenseID(int ExpenseID) {
        this.ExpenseID = ExpenseID;
    }

    // Set the date of payment
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Set the details or description of the expense
    public void setDetails(String details) {
        this.details = details;
    }

    // Set the company name associated with the expense
    public void setCompany(String company) {
        this.company = company;
    }

    // Set the invoice number for the expense
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    // Set the amount associated with the expense
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
