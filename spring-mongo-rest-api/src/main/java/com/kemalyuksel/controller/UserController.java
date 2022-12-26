package com.kemalyuksel.controller;

import com.kemalyuksel.entity.User;
import com.kemalyuksel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> AddUser(@RequestBody User user){
        return ResponseEntity.ok(userService.CreateUser(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<User> GetById(@PathVariable String id){
        return ResponseEntity.ok(userService.GetUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> GetAll(){
        return ResponseEntity.ok(userService.GetAllUsers());
    }

}
