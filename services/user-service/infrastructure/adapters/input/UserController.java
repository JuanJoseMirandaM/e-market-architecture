@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final RegisterUserUseCase registerUser;

    public UserController(RegisterUserUseCase registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDTO dto) {
        var token = registerUser.handle(
                new RegisterUserCommand(dto.email(), dto.password()));
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    record RegisterUserDTO(String email, String password) {}
}