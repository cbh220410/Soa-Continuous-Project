package com.klu.microservice21.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.microservice21.model.Task;

import com.klu.microservice21.repo.Taskrepository;

@Service
public class TaskService {

    @Autowired
    Taskrepository repo;

    @Autowired
    JWTService jwtservice;

    public Object createTask(Task task, String token) {

        Map<String, Object> response = new HashMap<>();

        try {

            Map<String, String> parsedJWT = jwtservice.validateJWT(token);

            task.setCreatedbywhom(
                Integer.parseInt(parsedJWT.get("id"))
            );

            repo.save(task);

            response.put("code", 200);
            response.put("message", "Task created successfully from task1");

        } catch (Exception e) {

            response.put("code", 500);
            response.put("message", e.getMessage());
        }

        return response;
    }
    public Object getAllTasks(int page, int size, String token) {
    	Map<String, Object> response = new HashMap<>();
    	
    	try {
    	Map<String, String> parsedJWT = jwtservice.validateJWT(token);
    	Pageable pageable = PageRequest.of(page-1, size);
    	Page<Task> tasks = repo.findAll(pageable);
    	response.put("code", 200);
    	response.put("page", page);
        response.put("size", size);
    	response.put("totalpages", tasks.getTotalPages());
        response.put("tasks", tasks.getContent());
    	return response;
    	}catch (Exception e) {
    	response.put("code", 500);
    	response.put("message", e.getMessage());
    	return response;
    	}
    }
    public Object updateTask(int id, Task task, String token) {
        Map<String, Object> response = new HashMap<>();

        try {
            Map<String, String> parsedJWT = jwtservice.validateJWT(token);
            Task task1 = repo.findById(id).get();

            if (task1 == null) {
                throw new Exception("user not exist");
            }

            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setAssignedto(task.getAssignedto());
            task1.setDeadline(task.getDeadline());
            task1.setPriority(task.getPriority());
            task1.setStatus(task.getStatus());
            task1.setCreatedbywhom(Integer.parseInt(parsedJWT.get("id")));

            repo.save(task1);

            response.put("code", 200);
            response.put("message", "updated successfully");

            return response;

        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", e.getMessage());

            return response;
        }
       
    } 
    public Object deleteTask(int id, String token) {

        Map<String, Object> response = new HashMap<>();

        try {

            Map<String, String> parsedJWT = jwtservice.validateJWT(token);

            Task task = repo.findById(id).get();

            if (task == null) {
                throw new Exception("Task not exist");
            }

            repo.deleteById(id);

            response.put("code", 200);
            response.put("message", "Task deleted successfully");

            return response;

        } catch (Exception e) {

            response.put("code", 500);
            response.put("message", e.getMessage());

            return response;
        }
    }
}
