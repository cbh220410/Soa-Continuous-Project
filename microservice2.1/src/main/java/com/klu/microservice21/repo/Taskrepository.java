package com.klu.microservice21.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.microservice21.model.Task;

public interface Taskrepository extends JpaRepository<Task, Integer>{

}
