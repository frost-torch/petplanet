package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.User;
import com.petplanet.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @SuppressWarnings("all")
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public @ResponseBody Map<String, Object> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/query")
    public @ResponseBody Map<String, Object> queryUser(@RequestParam String email) {
        System.out.println(email);
        return userService.queryUser(email);
    }

}
