package com.damelit.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damelit.dao.TaskDAO;
import com.damelit.model.Task;


@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDAO taskDAO;
	
 


public Task createTask(Task task) {
		return taskDAO.save(task);
	}

	 
	public Task findOne(Integer id) {
		return taskDAO.findOne(id);
	}
 
	public int delete(int id) {
		
		return taskDAO.delete(id);
	}
	@Override
	public Task update(Task task) {
		return taskDAO.save(task);
	}

	public List<Task> list() {
		return taskDAO.list();
	}
 



 



}