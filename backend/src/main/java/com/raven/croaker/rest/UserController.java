package com.raven.croaker.rest;

import com.raven.croaker.domain.Role;
import com.raven.croaker.domain.User;
import com.raven.croaker.dto.UserDTO;
import com.raven.croaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User currentUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return userService.findByUsername(principal.getName());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signupStandardUser(@RequestBody UserDTO userDTO) {
        if (userService.findByUsername(userDTO.getUsername()) != null) {
            return new ResponseEntity<>("Username already taken.", HttpStatus.CONFLICT);
        }
        if (userService.findByEmail(userDTO.getEmail()) != null) {
            return new ResponseEntity<>("Email already taken.", HttpStatus.CONFLICT);
        }
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail()); //TODO email validation
        user.setDisplayName(userDTO.getDisplayName());
        Role role = new Role();
        role.setId("1");
        role.setRoleName("STANDARD_USER"); //TODO stop making new roles
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
