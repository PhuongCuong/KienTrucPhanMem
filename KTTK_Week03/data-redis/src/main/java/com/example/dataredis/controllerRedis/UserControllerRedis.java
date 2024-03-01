package com.example.dataredis.controllerRedis;


import com.example.dataredis.moduleRedis.User;
import com.example.dataredis.responsitoryRedis.UserResponsitoryRedis;
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

    @PostMapping(value = "/create-user", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userResponsitoryRedis.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        if (userResponsitoryRedis.existsById(id)) {
            userResponsitoryRedis.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"delete\": \"ok\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"delete\": \"not found\"}");
        }
    }

    @PutMapping("/update-by-id")
    public ResponseEntity<String> updateById(@RequestBody User user) {
        if (userResponsitoryRedis.existsById(user.getId())) {
            userResponsitoryRedis.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"update\": \"ok\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"update\": \"not found\"}");
        }
    }

}
