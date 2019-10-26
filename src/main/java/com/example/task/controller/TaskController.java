package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/list")
public class TaskController {

    private TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/create")
    public void addTask(@RequestBody Task task) {
       task.setGenerateId(RandomStringUtils.randomAlphanumeric(12));
        this.repository.save(task);
    }
    @GetMapping
    public List<Task> getTasks(){
        return this.repository.findAll();
    }
    @DeleteMapping("/{generateId}")
    public void deleteTask(@PathVariable String generateId){
        Task taskToDel=this.repository.findByGenerateId(generateId);
        this.repository.delete(taskToDel);
    }
    @GetMapping("/{generateId}")
    public Task findTaskByGenerateId(@PathVariable String generateId) {
        return this.repository.findByGenerateId(generateId);
    }
    @PutMapping("/{generateId}/edit")
    public void editTask(@PathVariable String generateId,@RequestBody Task task){
        Task currentTask=this.repository.findByGenerateId(generateId);
        currentTask.setComplete(task.isComplete());
        currentTask.setTitle(task.getTitle());
        currentTask.setCreate_at(task.getCreate_at());
        currentTask.setUpdate_at(task.getUpdate_at());
        this.repository.save(currentTask);
    }
    @PutMapping("/{generateId}/complete")
    public void completeTask(@PathVariable String generateId,@RequestBody Task task) {
        Task currentTask = this.repository.findByGenerateId(generateId);
        currentTask.setComplete(true);
        this.repository.save(currentTask);
    }
    @GetMapping("/find")
    public List<Task>findComplete(@RequestParam("filter") boolean filter){
        return repository.findByComplete(filter);
    }
}