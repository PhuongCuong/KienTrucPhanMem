package com.example.compareredis.controller;

import com.example.compareredis.module.User;
import com.example.compareredis.responsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserResponsitory userResponsitory;

    @GetMapping("/get-all")
    public List<User> getAllUser(){
        return userResponsitory.findAll();
    }

    @PostMapping(value = "/create-user",consumes = "application/json")
    public ResponseEntity<String> createaddress(@RequestBody User user){
        if(userResponsitory.save(user) != null){
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"create\": \"not found\"}");
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteaddress(@RequestParam long id) {
        if (userResponsitory.existsById(id)) {
            userResponsitory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"delete\": \"ok\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"delete\": \"not found\"}");
        }
    }

    @PutMapping("/update-by-id")
    public ResponseEntity<String> updateaddress(@RequestBody User user){
        if(userResponsitory.existsById(user.getId())){
            userResponsitory.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"update\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"update\": \"not found\"}");
    }

}
