// Define the package that this class belongs to
package filter;

// Define the SearchOptionEvent interface
public interface SearchOptionEvent {

    // Define the method signature for the optionSelected method
    // This method is meant to be implemented by classes that implement this interface
    // Parameters:
    //   - option: A SearchOption object representing the selected search option.
    //   - index: An integer representing the index of the selected option in a list or array.
    public void optionSelected(SearchOption option, int index);
}
