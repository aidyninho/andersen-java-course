package exception;

public class IllegalPriceException extends RuntimeException {
    public IllegalPriceException(String message) {
        super(message);
    }
}
