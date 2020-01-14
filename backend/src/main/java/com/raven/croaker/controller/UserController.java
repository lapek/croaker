package com.raven.croaker.controller;

import com.raven.croaker.model.User;
import com.raven.croaker.model.UserList;
import com.raven.croaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping()
    public UserList getUsers() {
        return new UserList(userService.getAllUsers());
    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> modifyUser(@RequestBody @Valid User user, @PathVariable String id) {
        userService.modifyUser(user, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
