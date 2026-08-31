// Define the package that this class belongs to
package classes;

// Define the Credentials class
public class Credentials {

    // Define private fields for the Credentials class
    private int loginID; // An integer to store the login ID
    private String username; // A string to store the username
    private String email; // A string to store the email address
    private String password; // A string to store the password
    private String profilePic; // A string to store the URL of the profile picture

    // Define a constructor that takes loginID, username, email, password, and profilePic as parameters
    public Credentials(int loginID, String username, String email, String password, String profilePic) {
        // Set the values of the fields using the provided parameters
        this.loginID = loginID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    // Define a constructor that takes username and profilePic as parameters
    public Credentials(String username, String profilePic) {
        // Set the values of the fields using the provided parameters
        this.username = username;
        this.profilePic = profilePic;
    }

    // Define a method called "getLoginID" that returns the loginID field
    public int getLoginID() {
        return loginID;
    }

    // Define a method called "setLoginID" that takes an integer parameter loginID
    public void setLoginID(int loginID) {
        // Set the value of the loginID field using the provided parameter
        this.loginID = loginID;
    }

    // Define a method called "getUsername" that returns the username field
    public String getUsername() {
        return username;
    }

    // Define a method called "setUsername" that takes a string parameter username
    public void setUsername(String username) {
        // Set the value of the username field using the provided parameter
        this.username = username;
    }

    // Define a method called "getEmail" that returns the email field
    public String getEmail() {
        return email;
    }

    // Define a method called "setEmail" that takes a string parameter email
    public void setEmail(String email) {
        // Set the value of the email field using the provided parameter
        this.email = email;
    }

    // Define a method called "getPassword" that returns the password field
    public String getPassword() {
        return password;
    }

    // Define a method called "setPassword" that takes a string parameter password
    public void setPassword(String password) {
        // Set the value of the password field using the provided parameter
        this.password = password;
    }

    // Define a method called "getProfilePic" that returns the profilePic field
    public String getProfilePic() {
        return profilePic;
    }

    // Define a method called "setProfilePic" that takes a string parameter profilePic
    public void setProfilePic(String profilePic) {
        // Set the value of the profilePic field using the provided parameter
        this.profilePic = profilePic;
    }
}
