package exceptions;

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
