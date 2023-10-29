package com.damelit.service;

import java.util.List;

import com.damelit.model.Task;
 

public interface TaskService {

	Task createTask(Task task);

	Task update(Task task);

	Task findOne(Integer id);

	int delete(int id);

	List<Task> list();

	 

 

	
}