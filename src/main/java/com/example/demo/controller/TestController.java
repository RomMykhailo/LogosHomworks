package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {


    @GetMapping("/test")
    public ResponseEntity init (){

        return ResponseEntity.ok("{\"vreyug\":\"sivgg\"}");
    };

    @PostMapping("/test")
    public ResponseEntity<?> printText (
            @RequestBody String s
    ){

        System.out.println(s);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
