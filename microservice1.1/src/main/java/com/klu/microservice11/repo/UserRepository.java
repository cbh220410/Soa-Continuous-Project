package com.klu.microservice11.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.microservice11.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByusername(String Username);
}
