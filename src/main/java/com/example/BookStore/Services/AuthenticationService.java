package com.example.BookStore.Services;


import com.example.BookStore.Entities.User;
import com.example.BookStore.Mappers.UserMapper;
import com.example.BookStore.Repositories.UserRepository;
import com.example.BookStore.Requests.LoginUserRequest;
import com.example.BookStore.Requests.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    private UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    public User signup(RegisterUserRequest input) {
        User user = userMapper.ToEntity(input);

        return userRepository.save(user);
    }

    public User authenticate(LoginUserRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}