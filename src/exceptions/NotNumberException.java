package exceptions;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class NotNumberException extends Exception {
    String input;
    public NotNumberException(String message, String input){
        super(message);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
