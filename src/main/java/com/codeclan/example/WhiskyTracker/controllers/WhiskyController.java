package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    //    INDEX
    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies() {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);

    }

//    GET by ID

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id) {
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

//    PUT

    @PostMapping(value = "/whiskies")
    public ResponseEntity<Whisky> postWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

//    GET by age
    @GetMapping(value = "/whiskies")
    public ResponseEntity getWhiskyOfAge(
            @RequestParam(name = "age") int age

    ){
        List<Whisky> foundWhisky = whiskyRepository.findByAge(age);
        return new ResponseEntity(foundWhisky, HttpStatus.OK);
    }


}
