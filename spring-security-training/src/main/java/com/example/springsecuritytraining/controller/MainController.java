package com.example.springsecuritytraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/home")
    public String home() {
        return "This is home page";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "This is dashboard page";
    }

    @GetMapping("/manage")
    public String manage() {
        return "This is manage page";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class LoginRequest {
        private String username;
        private String password;
    }
}
