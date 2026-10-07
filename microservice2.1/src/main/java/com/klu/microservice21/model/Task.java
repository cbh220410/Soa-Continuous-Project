package com.klu.microservice21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
Integer id; 
String title;
String description;
Integer assignedto;
Integer priority;
Integer status;
String deadline;
Integer createdbywhom;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getAssignedto() {
	return assignedto;
}
public void setAssignedto(Integer assignedto) {
	this.assignedto = assignedto;
}
public Integer getPriority() {
	return priority;
}
public void setPriority(Integer priority) {
	this.priority = priority;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getDeadline() {
	return deadline;
}
public void setDeadline(String deadline) {
	this.deadline = deadline;
}
public Integer getCreatedbywhom() {
	return createdbywhom;
}
public void setCreatedbywhom(Integer createdbywhom) {
	this.createdbywhom = createdbywhom;
}
@Override
public String toString() {
	return "task [id=" + id + ", title=" + title + ", description=" + description + ", assignedto=" + assignedto
			+ ", priority=" + priority + ", status=" + status + ", deadline=" + deadline + ", createdbywhom="
			+ createdbywhom + "]";
}

}
