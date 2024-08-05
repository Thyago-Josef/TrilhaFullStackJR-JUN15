package com.projetocodigocerto.api.controller;

import com.projetocodigocerto.api.dto.request.UserRequest;
import com.projetocodigocerto.api.dto.response.UserResponse;
import com.projetocodigocerto.api.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;

    private final UserRepository userRepository;

    public TokenController(JwtEncoder jwtEncoder, UserRepository userRepository) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
    }

//    public String getToken(String login, String password) {
//        return jwtEncoder.encode(com.projetocodigocerto.api.dto.request.UserRequest
//                        .builder()
//                        .login(login)
//                        .password(password)
//                        .build())
//                .getTokenValue();
//    }


    @PostMapping("/token")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {

        var user = userRepository.findByLogin(userRequest.login());

        if(user.isEmpty()) {
            throw new BadCredentialsException("User not found");
        }


        return null;
    }

}
