package com.example.casestudythuenha_be.service.user;

import com.example.casestudythuenha_be.model.User;
import com.example.casestudythuenha_be.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);

    Optional<User> checkDoubleUser(String username);

}
