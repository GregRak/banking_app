package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "This is list of users";
    }

    @GetMapping("{userId}")
    public String getUser(@PathVariable Long userId) {
        return "This is specific user";
    }

    @PostMapping
    public String createUser() {
        return "Create user: ok";
    }

    @DeleteMapping("{userId}")
    public String deactiveUser() {
        return "User is deleted";
    }

    @PutMapping
    public String updateUser() {
        return "User updated";
    }
}
