package de.hsesslingen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hsesslingen.model.TodoItem;
import de.hsesslingen.repository.TodoItemRepository;


@RestController
public class TodoItemController 
{
	@Autowired
	private TodoItemRepository repo;
		
	@GetMapping("/")
	Iterable<TodoItem> todo()
	{
		return repo.findAll();
	}
	
	@PostMapping("/{todo}")
	String addTodo(@PathVariable String todo)
	{
		repo.save(new TodoItem(todo, false));
		return "added "+todo+" to todo list";
	}
	
	@DeleteMapping("/{id}")
	String deleteTodo(@PathVariable Long id)
	{
		TodoItem todo = repo.findOne(id);
		repo.delete(todo);
		return "removed "+todo.getName()+" from todo list";
	}
}