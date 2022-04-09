package exceptions;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class PastDataException extends Exception {
    public PastDataException (String message){
        super(message);
    }
}
