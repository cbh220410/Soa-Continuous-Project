package com.klu.microservice21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.microservice21.model.Task;
import com.klu.microservice21.service.TaskService;


@RestController
@RequestMapping("/ms2")
public class controler2 {

    @Autowired
    TaskService taskservice;

    @GetMapping("/mul")
    public String m(@RequestParam("a") int a,
                    @RequestParam("b") int b) {

        int r = a * b;

        return "multiplication " + r;
    }

    @PostMapping("/createtask")
    public Object createTask(@RequestBody Task task,
            @RequestHeader("Token") String token) {

        System.out.println("creation of task done " + task);

        return taskservice.createTask(task, token);
    }
    @GetMapping("/getalltasks/{PAGE}/{SIZE}")
    public Object getAllTasks(@PathVariable("PAGE") int page, @PathVariable("SIZE") int size, @RequestHeader("Token") String token) {
            return taskservice.getAllTasks(page, size, token);
    }
    @PutMapping("/updatetask/{ID}")
    public Object updateTask(@PathVariable("ID") int id, @RequestBody Task task, @RequestHeader("Token") String token) {
           return taskservice.updateTask(id, task, token);
   }
    @DeleteMapping("/deletetask/{ID}")
    public Object deleteTask(@PathVariable("ID") int id,
                             @RequestHeader("Token") String token) {

        return taskservice.deleteTask(id, token);
    }
}