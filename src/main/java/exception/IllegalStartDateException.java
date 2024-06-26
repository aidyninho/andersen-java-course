package exception;

public class IllegalStartDateException extends RuntimeException {
    public IllegalStartDateException(String message) {
        super(message);
    }
}
