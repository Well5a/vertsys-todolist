package de.hsesslingen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsesslingen.model.TodoItem;


@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long>
{
	public List<TodoItem> findByTodo(String todo);
}