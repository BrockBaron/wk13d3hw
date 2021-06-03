package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    //    INDEX
    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries() {
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);

    }

//    GET by ID

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id) {
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

//    PUT

    @PostMapping(value = "/distilleries")
    public ResponseEntity<Distillery> postDistillery(@RequestBody Distillery distillery){
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

    //    GET by region
    @GetMapping(value = "/distilleries")
    public ResponseEntity getDistilleriesByRegion(
            @RequestParam(name = "region") String region

    ){
        List<Distillery> foundDistillery = distilleryRepository.findDistilleryByRegion(region);
        return new ResponseEntity(foundDistillery, HttpStatus.OK);
    }

    //    GET by whisky age
    @GetMapping(value = "/distilleries/whiskies")
    public ResponseEntity getDistilleriesByWhiskyAge(
            @RequestParam(name = "age") int age

    ){
        List<Distillery> foundDistillery = distilleryRepository.findByWhiskyAge(age);
        return new ResponseEntity(foundDistillery, HttpStatus.OK);
    }


}


