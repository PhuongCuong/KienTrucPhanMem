package com.example.compareredis.controllerRedis;

import com.example.compareredis.moduleRedis.User;
import com.example.compareredis.responsitoryRedis.UserResponsitoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user-redis")
public class UserControllerRedis {
    @Autowired
    private UserResponsitoryRedis userResponsitoryRedis;

    @GetMapping("/get-all")
    public List<com.example.compareredis.moduleRedis.User> getAllUser(){
        return (List<User>) userResponsitoryRedis.findAll();
    }

    @PostMapping(value = "/create-user",consumes = "application/json")
    public ResponseEntity<String> createaddress(@RequestBody com.example.compareredis.moduleRedis.User user){
        if(userResponsitoryRedis.save(user) != null){
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"create\": \"not found\"}");
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteaddress(@RequestParam long id) {
        if (userResponsitoryRedis.existsById(id)) {
            userResponsitoryRedis.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"delete\": \"ok\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"delete\": \"not found\"}");
        }
    }

    @PutMapping("/update-by-id")
    public ResponseEntity<String> updateaddress(@RequestBody User user){
        if(userResponsitoryRedis.existsById(user.getId())){
            userResponsitoryRedis.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"update\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"update\": \"not found\"}");
    }

}
