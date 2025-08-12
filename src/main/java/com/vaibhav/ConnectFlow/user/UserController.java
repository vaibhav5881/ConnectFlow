package com.vaibhav.ConnectFlow.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public void register(User user){
        userService.register(user);
    }

    @PostMapping("/login")
    public User login(User user){
        return userService.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email){
        userService.logout(email);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e){
        e.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

}
