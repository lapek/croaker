package com.raven.croaker.rest;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.User;
import com.raven.croaker.dto.CroakDTO;
import com.raven.croaker.service.CroakService;
import com.raven.croaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/croak")
public class CroakController {
    private CroakService croakService;
    private UserService userService;

    @Autowired
    public CroakController(CroakService croakService, UserService userService) {
        this.croakService = croakService;
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Croak>> getAll() {
        return new ResponseEntity<>(croakService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Croak>> getAllFromUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(croakService.findAllFromUser(username), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Croak> saveCroak(@RequestBody CroakDTO croakDTO, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByUsername(principal.getName());
        Croak croak = new Croak();
        croak.setMessage(croakDTO.getMessage());
        croak.setUserId(user.getId());
        croak.setUsername(user.getUsername());
        return new ResponseEntity<>(croakService.save(croak), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Croak> deleteCroak(@RequestBody Croak croak, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByUsername(principal.getName());
        if (croak.getUserId().equals(user.getId()) && Objects.equals(croak.getUsername(), user.getUsername())) {
            croakService.delete(croak);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
