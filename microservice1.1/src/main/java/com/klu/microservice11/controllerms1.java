package com.klu.microservice11;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.microservice11.model.User;
import com.klu.microservice11.service.UserService;

@RestController
@RequestMapping("/ms1")
public class controllerms1 {

    @Autowired
    UserService service;

    @GetMapping("/add")
    public String add(
            @RequestParam("a") int a,
            @RequestParam("b") int b) {

        int r = a + b;

        return "ms1.1 " + r;
    }
    @PostMapping("/signup")
    public Object signup(@RequestBody User u) {
        return service.signupService(u);
    }
    @PostMapping("/signin")
    public Object signin(@RequestBody Map<String, String> u) {
    	 return service.signinService(u);
    }
    
    
}