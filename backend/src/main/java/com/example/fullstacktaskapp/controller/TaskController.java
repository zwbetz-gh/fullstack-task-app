package com.example.fullstacktaskapp.controller;

import java.util.List;

import com.example.fullstacktaskapp.entity.Task;
import com.example.fullstacktaskapp.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;
  
  @GetMapping("/tasks")
  public List<Task> getTasks() {
    return taskRepository.findAll();
  }
}
