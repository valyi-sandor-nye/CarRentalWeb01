package hu.valyis.progenv.carrentalweb01.exception;

public class NosuchEntityException extends RuntimeException {
    public NosuchEntityException(String message) {
        super(message);
    }

    public NosuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}

