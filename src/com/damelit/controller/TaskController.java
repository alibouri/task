package com.damelit.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.damelit.model.Task;
import com.damelit.service.TaskService;
 

@RestController
@RequestMapping("tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

 
	@PostMapping()
	public @ResponseBody ResponseEntity<Task> create(@RequestBody Task task) {
		System.out.println("TaskController->Create" + task.getTaskId()  +"," + task.getTaskDescription() + " " + task.getDueDate());
		
		Task createdTask = taskService.createTask(task);
		return new ResponseEntity<Task>(createdTask, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable("id") Integer id,@RequestBody Task task) {
		System.out.println("TaskController->update" + id + " " + task.getDueDate());
		System.out.println(task.getDueDate());
		
		LocalDateTime date = task.getDueDate();
		date.plusHours(4);
		task.setDueDate(date);
		Task t = taskService.update(task);
		return new ResponseEntity<Task>(t, HttpStatus.OK);
	}
	
	
	@GetMapping()
	public List<Task> list() {
		List<Task> list = taskService.list();
		return list;
	}

	@GetMapping("/{id}")
	public Task findOne(@PathVariable("id") Integer id) {
		return taskService.findOne(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
		int task = taskService.delete(id);
		if(task!=0) {
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
