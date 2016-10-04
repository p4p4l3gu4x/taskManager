package com.hudson.task.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hudson.task.manager.model.Task;
import com.hudson.task.manager.repository.TaskManagerRepository;

@RestController
public class TaskManagerController {
	
	@Autowired
	private TaskManagerRepository repository;
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> listAll(){
		ResponseEntity<List<Task>> response;
		List<Task> tasks = repository.findAll();
		if(tasks.size() == 0){
			response = new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}else{
			response = new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Void> createTask(@RequestBody Task task,  UriComponentsBuilder ucBuilder) {
        repository.insert(task);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task){
		
		System.out.println(task.getId());
		
		Task taskToEdit = repository.findOne(task.getId());
		System.out.println(taskToEdit.getId());
		
		taskToEdit.setTaskTitle(task.getTaskTitle());
		taskToEdit.setTaskDescription(task.getTaskDescription());
		taskToEdit.setPriority(task.getPriority());
		taskToEdit.setStatus(task.getStatus());
		
		repository.save(taskToEdit);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTask(@PathVariable("id") String id){
		Task taskToDelete = repository.findOne(id);
		
		repository.delete(taskToDelete);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}