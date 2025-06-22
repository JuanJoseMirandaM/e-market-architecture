@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringUserJpaRepository jpa;

    public JpaUserRepositoryAdapter(SpringUserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email).map(UserEntity::toDomain);
    }
    @Override public User save(User user) {
        return jpa.save(UserEntity.from(user)).toDomain();
    }
    @Override public Optional<User> findById(UUID id) {
        return jpa.findById(id).map(UserEntity::toDomain);
    }
}