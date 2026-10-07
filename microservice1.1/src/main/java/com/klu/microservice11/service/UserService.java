package com.klu.microservice11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import com.klu.microservice11.model.User;
import com.klu.microservice11.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository UR;

    @Autowired
    JWTService jwtService;

    public Object signupService(User u1) {
        Map<String,Object>response=new HashMap<>();
        try {
        	User user= UR.findByusername(u1.getUsername());
        	if(user !=null) {
        		response.put("code", 500);
        		response.put("message","user already exist");
        	}
        	else {
        		u1.setRole(1);
        		UR.save(u1);
        		response.put("code", 200);
        		response.put("message","success");
        	}
        	return response;
        } 	
        catch(Exception e) {
        	response.put("code", 500);
        	response.put("message",e.getMessage());
        	return response;
        }
       
    }
    public Object signinService(Map<String,String> u1) {
    	Map<String,Object>response=new HashMap<>();
         
          try {
        	  User user= UR.findByusername(u1.get("username"));
        	  if(user ==null||!user.getPassword().equals(u1.get("password"))){
        		  response.put("code",500);
        		  response.put("message","failed");
        	  }
        	  else {
        		  response.put("code",200);
        		  response.put("jwt", jwtService.generateJWT(u1,user.getRole().toString(),user.getId()));
        	  }
        	  return response;
          } 	
          catch(Exception e) {
          	response.put("code", 500);
          	response.put("message",e.getMessage());
          	return response;
          }
    
    }
    
    
    
}