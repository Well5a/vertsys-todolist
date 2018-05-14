package de.hsesslingen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsesslingen.model.TodoItem;


@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {}