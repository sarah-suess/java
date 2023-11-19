/**
* Used to create an unchecked exception.
* @author ssuess3
* @version 11.0.16.1
*/
public class NegativeQuantityException extends RuntimeException {

    /**
    * Used to create a NegativeQuantityException.
    * @param s string value of invalid input
    */
    public NegativeQuantityException(String s) {
        super("Quantity " + s + " is not positive.");
    }
}