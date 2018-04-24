package de.hsesslingen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.hsesslingen.model.TodoItem;
import de.hsesslingen.repository.TodoItemRepository;

@Controller
public class TodoItemUIController 
{
	@Autowired
	private TodoItemRepository repo;
	
	@RequestMapping("/ui")
	String list(Model model)
	{
		Iterable<TodoItem> todos = repo.findAll();
		model.addAttribute("todos", todos);
		return "todos";
	}
}
