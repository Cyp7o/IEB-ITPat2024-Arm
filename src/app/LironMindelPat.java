// Define the package that this class belongs to
package app;

// Import the necessary classes from the "view" package
import view.LoginScreen;
import view.SplashScreen;
import view.HomeScreen; // This import is not used in the current code, but might be necessary in the future

// Define the main class "LironMindelPat"
public class LironMindelPat {

    // Define the main method that serves as the entry point of the application
    public static void main(String[] args) {
        // Create instances of SplashScreen and LoginScreen classes
        SplashScreen screen = new SplashScreen();
        LoginScreen sign = new LoginScreen();

        // Make the splash screen visible to the user
        screen.setVisible(true);

        // Use a try-catch block to handle any potential exceptions
        try {
            // Loop to simulate loading progress
            for (int row = 0; row <= 100; row += 10) {
                // Pause the thread for 100 milliseconds to simulate loading time
                Thread.sleep(100);

                // Update the loading number and progress bar on the splash screen
                screen.loadingnumber.setText(Integer.toString(row) + "%");
                screen.loadingprogress.setValue(row);

                // Check if loading is complete
                if (row == 100) {
                    // Hide the splash screen
                    screen.setVisible(false);
                    // Show the login screen
                    sign.setVisible(true);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the loading process
            e.printStackTrace();
        }
    }
}
