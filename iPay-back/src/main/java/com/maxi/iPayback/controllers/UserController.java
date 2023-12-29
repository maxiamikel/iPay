package com.maxi.iPayback.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.iPayback.dtos.UserDTO;
import com.maxi.iPayback.entities.user.User;
import com.maxi.iPayback.serices.UserServiceImpl;

@RestController
@RequestMapping("/api/ipay/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/new")
    public ResponseEntity<?> createUser(@RequestBody UserDTO obj) {
        try {
            this.userService.addNerUser(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsers() {
        List<User> userList = new ArrayList<User>();
        userList = this.userService.findAllUsers();
        return ResponseEntity.ok().body(userList);
    }
}
