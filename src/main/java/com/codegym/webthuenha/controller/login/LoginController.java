package com.codegym.webthuenha.controller.login;
import com.codegym.webthuenha.model.DTO.SocialDTO;
import com.codegym.webthuenha.model.DTO.UserRegisterDTO;
import com.codegym.webthuenha.model.JwtResponse;
import com.codegym.webthuenha.model.User;
import com.codegym.webthuenha.repository.IUserRepository;
import com.codegym.webthuenha.service.image.IImageService;
import com.codegym.webthuenha.service.jwt.JwtService;
import com.codegym.webthuenha.service.role.IRoleService;
import com.codegym.webthuenha.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Autowired
    private IImageService iImageService;

    @Autowired
    IUserRepository iUserRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.createToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.findByUsername(user.getUsername());
            return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
        } catch (Exception e) {
            return ResponseEntity.ok("Not Found User");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegisterDTO user) {
        if (userService.checkDoubleUser(user.getUserName()).isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User users = new User();
        users.setUsername(user.getUserName());
        users.setPassword(user.getPassword());
        users.setPhoneNumber(user.getPhone());
        users.setEmail(user.getEmail());
        users.setAvatar(iImageService.findById(Long.parseLong("1")).get().getImageName());
        String role = "2";
        Long role1 = Long.parseLong(role);
        users.setRole(roleService.findById(role1).get());
        userService.save(users);

        return new ResponseEntity<>(userService.save(users),HttpStatus.OK);
    }

    @PostMapping("/register1")
    public ResponseEntity<?> register1(@RequestBody SocialDTO socialDTO) {
        User user1 = iUserRepository.checkEmailUser(socialDTO.getEmail());


        if (user1==null){
            User users = new User();
            users.setUsername(socialDTO.getName());
            users.setPassword("0101010101");
            users.setPhoneNumber("");
            users.setEmail(socialDTO.getEmail());
            users.setAvatar(socialDTO.getPhotoUrl());
            String role = "2";
            Long role1 = Long.parseLong(role);
            users.setRole(roleService.findById(role1).get());
            userService.save(users);
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);

                String jwt = socialDTO.getIdToken();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                User currentUser = userService.findByUsername(users.getUsername());
                return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
            } catch (Exception e) {
                return new ResponseEntity<>("khoong dc ",HttpStatus.BAD_REQUEST);  }
        }else  {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(socialDTO.getName(), "0101010101"));
                SecurityContextHolder.getContext().setAuthentication(authentication);

                String jwt = socialDTO.getIdToken();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                User currentUser = userService.findByUsername(socialDTO.getName());
                return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
            } catch (Exception e) {
                return new ResponseEntity<>("khoong dc ",HttpStatus.BAD_REQUEST);  }

        }
    }
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("Admin", HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("User", HttpStatus.OK);
    }
    @PutMapping("/editPassword/{id}")
    public ResponseEntity<User> updatePassWord(@PathVariable Long id,@RequestBody String password){
        Optional<User> userOptional = this.userService.findById(id);
        if (!userOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();
        user.setPassword(password);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}