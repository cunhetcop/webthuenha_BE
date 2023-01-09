package com.example.casestudythuenha_be.service.user;

import com.example.casestudythuenha_be.model.House;
import com.example.casestudythuenha_be.model.User;
import com.example.casestudythuenha_be.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<org.springframework.security.core.userdetails.User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public org.springframework.security.core.userdetails.User findById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public User save(House house) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Optional<User> checkDoubleUser(String username) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
