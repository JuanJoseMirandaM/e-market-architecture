public class RegisterUserUseCase {

    private final UserRepositoryPort userRepo;
    private final PasswordEncoder encoder;
    private final TokenProviderPort tokenProvider;
    private final EventPublisherPort eventPublisher;

    public RegisterUserUseCase(UserRepositoryPort userRepo,
                               PasswordEncoder encoder,
                               TokenProviderPort tokenProvider,
                               EventPublisherPort eventPublisher) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.tokenProvider = tokenProvider;
        this.eventPublisher = eventPublisher;
    }

    public String handle(RegisterUserCommand cmd) {
        userRepo.findByEmail(cmd.email())
                .ifPresent(u -> { throw new DuplicateEmailException(cmd.email()); });

        var user = new User(
                UUID.randomUUID(),
                new Email(cmd.email()),
                new PasswordHash(encoder.encode(cmd.password())),
                Set.of(Role.CUSTOMER));

        userRepo.save(user);

        // Publicamos evento de integración
        eventPublisher.publish("user.registered", user);

        return tokenProvider.generateToken(user);
    }
}