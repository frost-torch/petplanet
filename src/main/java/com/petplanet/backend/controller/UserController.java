package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.User;
import com.petplanet.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @SuppressWarnings("all")
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public Map<String, Object> addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/query")
    public Map<String, Object> queryUser(String email) {
        return userService.queryUser(email);
    }

}
