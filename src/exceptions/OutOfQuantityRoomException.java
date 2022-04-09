package exceptions;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class OutOfQuantityRoomException extends Exception {
    public OutOfQuantityRoomException(String message){
        super(message);
    }
}
