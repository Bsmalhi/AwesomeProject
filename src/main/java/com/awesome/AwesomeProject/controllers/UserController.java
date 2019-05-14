package com.awesome.AwesomeProject.controllers;

import com.awesome.AwesomeProject.models.User;
import com.awesome.AwesomeProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

//import org.apache.log4j.Logger;

@RestController(value = "/api")
public class UserController {

    private final Logger LOG = (Logger) Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUpUser(@RequestBody User user){
        HashMap<String, String> resultMap = new HashMap<>();

        if(user == null || user.getPassWord() == null  || user.getUserName() == null){
            resultMap.put("serviceMsg", "Please check your input again.");
            return new ResponseEntity<Map<String, String>>(resultMap, HttpStatus.BAD_REQUEST);
        }
        Optional<User> userOptional = Optional.of(userService.findByUserName(user.getUserName()));

        if(userOptional.isPresent()){
            LOG.info("User already present with userName: " + userOptional.get().getUserName());
            resultMap.put("serviceMsg", "UserName is already present. Please try again!");
            return new ResponseEntity<>(resultMap, HttpStatus.CONFLICT);
        }
            userService.save(user);
            LOG.info("Created User with userName: " + user.getUserName());
            resultMap.put("serviceMsg", "New User added");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);

    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signInUser(@RequestBody String payload){
        HashMap<String, String> resultMap = new HashMap<>();
        // get String payload user/pass and then validate -> send OK or 401


    }
}
