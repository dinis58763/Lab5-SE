package exceptions;

import java.io.Serial;

public class ContactDoesNotExistException extends Exception {
    private static final String CONTACT_DOES_NOT_EXIST = "Contact does not exist.";

    @Serial
    private static final long serialVersionUID = 1117444551654899410L;
    public ContactDoesNotExistException() {
        super(CONTACT_DOES_NOT_EXIST);
    }
}
