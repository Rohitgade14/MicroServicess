package com.patilsoft.hotel.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffContoller {

    @GetMapping
    public ResponseEntity<List<String>> allStaff(){
        List<String> list = Arrays.asList("Ram", "kiran");
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
