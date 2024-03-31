package com.Kidou.controller;

import com.Kidou.config.TokenService;
import com.Kidou.entities.user.records.RegisterDTO;
import com.Kidou.entities.user.Users;
import com.Kidou.entities.user.records.LoginDTO;
import com.Kidou.entities.user.records.Token;
import com.Kidou.repositorys.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto) {

        String passwordEncode = passwordEncoder.encode(dto.password());
        Users u = new Users(dto.name(), dto.email(), passwordEncode, dto.sexo(), dto.role());
        userRepository.save(u);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO dto) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

      String token =  tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new Token(token));
    }


}
