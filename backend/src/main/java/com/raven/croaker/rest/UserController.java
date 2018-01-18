package com.raven.croaker.rest;

import com.raven.croaker.domain.Role;
import com.raven.croaker.domain.User;
import com.raven.croaker.dto.UserDTO;
import com.raven.croaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${security.encoding-strength}")
    private Integer encodingStrength;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

//    @RequestMapping({ "/profile", "/me" }) //TODO return profile/user informations
////    public Map<String, String> user(Principal principal) {
////        Map<String, String> map = new LinkedHashMap<>();
////        map.put("name", principal.getName());
////        return map;
////    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
        if (userService.findByUsername(userDTO.getUsername()) != null) {
            throw new RuntimeException("Username already exist.");
        }
        if (userService.findByEmail(userDTO.getUsername()) != null) {
            throw new RuntimeException("Email already taken.");
        }
        User user = new User();
        user.setPassword(new BCryptPasswordEncoder(encodingStrength).encode(userDTO.getPassword()));
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
