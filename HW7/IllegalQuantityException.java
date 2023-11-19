/**
* Used to create a checked exception.
* @author ssuess3
* @version 11.0.16.1
*/
public class IllegalQuantityException extends Exception {

    /**
    * Used to create an IllegalQuantityException.
    * @param s string value of invalid input
    */
    public IllegalQuantityException(String s) {
        super("Quantity " + s + " is not a number.");
    }
}