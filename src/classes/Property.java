// Package declaration
// This class is part of the 'classes' package.
package classes;

public class Property {
    // Instance variables
    private int propertyID;      // Unique identifier for the property
    private String complex;      // Name of the complex the property is in
    private String unitNo;       // Unit number of the property
    private String address;      // Physical address of the property
    private String suburb;       // Suburb where the property is located
    private String category;     // Category of the property (e.g., residential, commercial)
    private int bedrooms;        // Number of bedrooms in the property
    private double bathrooms;    // Number of bathrooms in the property
    private boolean occupied;    // Occupancy status of the property
    private int rent;            // Rent amount for the property
    private String image;        // Image URL or path for the property

    // Constructor
    // Initializes a new instance of the Property class with the provided values.
    public Property(int propertyID, String suburb, String complex, String unitNo, String address, String category, int bedrooms, double bathrooms, boolean occupied, int rent, String image) {
        this.propertyID = propertyID;
        this.complex = complex;
        this.unitNo = unitNo;
        this.address = address;
        this.suburb = suburb;
        this.category = category;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.occupied = occupied;
        this.rent = rent;
        this.image = image;
    }

    // Getter methods
    // Return the value of the respective instance variables.
    public int getPropertyID() {
        return propertyID;
    }

    public String getComplex() {
        return complex;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public String getAddress() {
        return address;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCategory() {
        return category;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getRent() {
        return rent;
    }

    public String getImage() {
        return image;
    }

    // Setter methods
    // Set the value of the respective instance variables.
    
    /**
     * @param propertyID the propertyID to set
     */
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    /**
     * @param complex the complex to set
     */
    public void setComplex(String complex) {
        this.complex = complex;
    }

    /**
     * @param unitNo the unitNo to set
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param suburb the suburb to set
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @param bedrooms the bedrooms to set
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * @param bathrooms the bathrooms to set
     */
    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * @param occupied the occupied to set
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(int rent) {
        this.rent = rent;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
