timepackage com.kaviya.foodbridge.controller;

import com.kaviya.foodbridge.dto.RegisterRequest;
import com.kaviya.foodbridge.entity.User;
import com.kaviya.foodbridge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.kaviya.foodbridge.dto.LoginRequest;
import com.kaviya.foodbridge.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Controller Working";
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {

        System.out.println("Register API called");
        return userService.register(request);

    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}