// Define the package that this class belongs to
package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Payment class represents a payment made by a tenant.
 * It contains details about the payment such as the payment ID,
 * tenant ID, amount, invoice number, and the date the payment was created.
 */
public class Payment {
    private int PaymentID; // Unique identifier for the payment
    private int tenantID; // Identifier for the tenant associated with the payment
    private String tenant; // Name of the tenant (Note: This field is not used in the current implementation)
    private double Amount; // Amount of the payment
    private String invoiceNo; // Invoice number associated with the payment
    private LocalDate datecreated; // Date when the payment was created

    /**
     * Constructor to initialize all fields of the Payment class.
     * 
     * @param PaymentID The unique identifier for the payment.
     * @param tenantID The unique identifier for the tenant associated with the payment.
     * @param Amount The amount of the payment.
     * @param invoiceNo The invoice number associated with the payment.
     * @param datecreated The date when the payment was created.
     */
    public Payment(int PaymentID, int tenantID, double Amount, String invoiceNo, LocalDate datecreated) {
        this.PaymentID = PaymentID;
        this.tenantID = tenantID;
        this.Amount = Amount;
        this.invoiceNo = invoiceNo;
        this.datecreated = datecreated;
    }

    /**
     * Constructor to initialize the Payment class without PaymentID.
     * Useful when creating new payments where the ID will be generated automatically.
     * 
     * @param tenantID The unique identifier for the tenant associated with the payment.
     * @param Amount The amount of the payment.
     * @param invoiceNo The invoice number associated with the payment.
     * @param datecreated The date when the payment was created.
     */
    public Payment(int tenantID, double Amount, String invoiceNo, LocalDate datecreated) {
        this.tenantID = tenantID;
        this.Amount = Amount;
        this.invoiceNo = invoiceNo;
        this.datecreated = datecreated;
    }

    // Getters

    /**
     * @return The unique identifier for the payment.
     */
    public int getPaymentID() {
        return PaymentID;
    }

    /**
     * @return The unique identifier for the tenant associated with the payment.
     */
    public int getTenantID() {
        return tenantID;
    }

    /**
     * @return The amount of the payment.
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * @return The invoice number associated with the payment.
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @return The date when the payment was created, formatted as "yyyy-MM-dd".
     */
    public String getDateCreated() {
        return datecreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
