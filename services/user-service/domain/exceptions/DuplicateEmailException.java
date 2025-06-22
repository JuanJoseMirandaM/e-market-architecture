public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("E-mail already registered: " + email);
    }
}