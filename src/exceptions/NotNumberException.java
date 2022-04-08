package exceptions;

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
