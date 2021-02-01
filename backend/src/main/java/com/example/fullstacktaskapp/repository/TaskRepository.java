package com.example.fullstacktaskapp.repository;

import java.util.List;

import com.example.fullstacktaskapp.entity.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
  
  Task findById(long id);

  List<Task> findAll();
}
