package com.agri.learnings.controller;

import com.agri.learnings.request.CommonRequest;
import com.agri.learnings.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open/v1.0")
public class AppController {
    UserService userService;

    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody CommonRequest commonRequest) {
        return userService.login(commonRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody CommonRequest commonRequest) {
        return userService.saveUserDetails(commonRequest);
    }
}
