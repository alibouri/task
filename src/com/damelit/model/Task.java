package com.damelit.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT2TASKS")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskid_gen")
	@SequenceGenerator(name = "taskid_gen", sequenceName = "PROJECT2_TASK_ID", allocationSize = 1)
	@Column(name = "TASK_ID")
	private int taskId;
	
	@Column(name = "TASKDATE")
	private LocalDateTime dueDate;
	
	@Column(name = "TASK_DESCRIPTION") 
	private String taskDescription;
	
	
	@Column(name = "TASK_TITLE")
	private String title;
	
 
	@Column(name = "TASKSTATUS")
	private String taskStatus;
	
 

 
 

	@Override
	public int hashCode() {
		return Objects.hash(dueDate, taskDescription, taskId, taskStatus, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(dueDate, other.dueDate) && Objects.equals(taskDescription, other.taskDescription)
				&& taskId == other.taskId && Objects.equals(taskStatus, other.taskStatus)
				&& Objects.equals(title, other.title);
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int taskId, LocalDateTime dueDate, String taskDescription, String title,
			String taskStatus ) {
		super();
		this.taskId = taskId;
		this.dueDate = dueDate;
		this.taskDescription = taskDescription;
		this.title =title;
		this.taskStatus = taskStatus;
 
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

 

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

 
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
 
 

 

	
}