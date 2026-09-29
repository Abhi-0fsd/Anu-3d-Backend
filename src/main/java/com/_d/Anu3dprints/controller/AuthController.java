package com._d.Anu3dprints.controller;


import com._d.Anu3dprints.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody Map<String, String> request) {

        String token = authService.signup(
                request.get("name"),
                request.get("email"),
                request.get("password")
        );

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Signup successful",
                        "token",
                        token
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> request) {

        String token = authService.login(
                request.get("email"),
                request.get("password")
        );

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Login successful",
                        "token",
                        token
                )
        );
    }
}