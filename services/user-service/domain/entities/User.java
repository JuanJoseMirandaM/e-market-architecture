public class User {
    private final UUID id;
    private Email email;
    private PasswordHash passwordHash;
    private Set<Role> roles;

    public User(UUID id, Email email, PasswordHash passwordHash, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }
}