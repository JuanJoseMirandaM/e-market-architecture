public interface UserRepositoryPort {
    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findById(UUID id);
}