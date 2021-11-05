package exceptions;

public class ContactDoesNotExistException extends Exception {
    private static final String CONTACT_ALREADY_EXISTS = "Contact already exists.";
    /**
     *
     */
    private static final long serialVersionUID = 1117444551654899410L;
    public ContactDoesNotExistException() {
        super("Contact does not exist.");
    }
}
