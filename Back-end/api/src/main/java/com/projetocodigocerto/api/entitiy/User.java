package com.projetocodigocerto.api.entitiy;

import com.projetocodigocerto.api.dto.request.UserRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class User {

    @Id
    private Long id;
    private String login;
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  Boolean isLoginCorrect(UserRequest userRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(userRequest.password(), this.password);
    }
}
