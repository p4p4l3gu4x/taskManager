package com.hudson.task.manager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hudson.task.manager.model.Task;

@Repository
public interface TaskManagerRepository extends MongoRepository<Task, String> {
	
	Task findById(String id); 
}
