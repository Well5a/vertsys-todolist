package de.hsesslingen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem 
{
	@Id
	@GeneratedValue
	long Id;
	
	String todo;
	boolean isDone;
	
	public TodoItem() {}
	
	public TodoItem(String todo, boolean isDone)
	{
		this.todo 	= todo;
		this.isDone = isDone;
	}
	
	public String getTodo() {
		return todo;
	}
	
	public long getId() {
		return Id;
	}
	
	public boolean getIsDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}