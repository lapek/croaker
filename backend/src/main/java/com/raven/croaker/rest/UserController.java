package com.raven.croaker.rest;

import com.raven.croaker.dto.UserDTO;
import com.raven.croaker.domain.Role;
import com.raven.croaker.domain.User;
import com.raven.croaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${security.encoding-strength}")
    private Integer encodingStrength;

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Iterable<User> getUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
//        if (userService.findByUsername(user.getUsername()) != null) {
//            throw new RuntimeException("Username already exist");
//        }
        User user = new User();
//        user.setId("104"); //TODO Test that, should autogenerate id
        user.setPassword(new BCryptPasswordEncoder(encodingStrength).encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        Role role = new Role();
        role.setId("1");
        role.setRoleName("STANDARD_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
