package com.example.casestudythuenha_be.service.user;

import com.example.casestudythuenha_be.model.House;
import com.example.casestudythuenha_be.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<org.springframework.security.core.userdetails.User> findAll();

    org.springframework.security.core.userdetails.User findById(Long id);

    void deleteById(Long id);

    User save(House house);
    User findByUsername(String username);

    Optional<User> checkDoubleUser(String username);
}
