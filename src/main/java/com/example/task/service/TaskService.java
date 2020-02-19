package com.example.task.service;

import com.example.task.model.Task;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface TaskService extends UserDetailsService {
  Task create(Task task);
}
