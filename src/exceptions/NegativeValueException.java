package exceptions;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class NegativeValueException extends Exception {
    double value;
    public NegativeValueException(String message, double value){
        super(message);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
