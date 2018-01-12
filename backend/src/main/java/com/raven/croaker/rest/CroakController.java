package com.raven.croaker.rest;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.service.CroakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/croak")
public class CroakController {
    @Autowired
    private CroakService croakService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Croak>> getAll() {
        return new ResponseEntity<Iterable<Croak>>(croakService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Croak> saveCroak(@RequestBody Croak croak) {
        return new ResponseEntity<Croak>(croakService.save(croak), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Croak> deleteCroak(@RequestBody Croak croak) {
        croakService.delete(croak);
        return new ResponseEntity<Croak>(HttpStatus.NO_CONTENT);
    }

}
