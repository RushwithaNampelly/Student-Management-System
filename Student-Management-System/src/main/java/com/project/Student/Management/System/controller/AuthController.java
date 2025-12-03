package com.project.Student.Management.System.controller;

import com.project.Student.Management.System.models.User;
import com.project.Student.Management.System.services.AuthService;
import com.project.Student.Management.System.DTO.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // -------- REGISTER ----------
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user) {
        User saved = authService.register(user);
        UserDto dto = new UserDto(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // small class for login body
    public static class LoginRequest {
        public String email;
        public String password;
    }

    // -------- LOGIN ----------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        boolean ok = authService.login(req.email, req.password);
        if (!ok) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
        // if needed, fetch user to send details
        User user = authService.getByEmail(req.email);
        UserDto dto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(dto);
    }
}

