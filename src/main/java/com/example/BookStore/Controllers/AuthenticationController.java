package com.example.BookStore.Controllers;

import com.example.BookStore.Entities.User;
import com.example.BookStore.Requests.LoginUserRequest;
import com.example.BookStore.Requests.RegisterUserRequest;
import com.example.BookStore.Responses.LoginResponse;
import com.example.BookStore.Services.AuthenticationService;
import com.example.BookStore.Services.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;



    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        User registeredUser = authenticationService.signup(registerUserRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserRequest loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }
}