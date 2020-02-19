package com.example.task.controller;

import com.example.task.error.AlreadyExistException;
import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskServiceImpl taskServiceimpl;


    @PostMapping("/create")
    public void createTask(@RequestBody Task task) {
        this.taskServiceimpl.create(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return this.repository.findAll();
    }

    @DeleteMapping("/{generateId}")
    public void deleteTask(@PathVariable String generateId){
        Task taskToDel=this.repository.findByGenerateId(generateId);
        this.repository.delete(taskToDel);
    }

    @ApiOperation(value = "GGWP")
    @GetMapping("/{generateId}")
    public Task findTaskByGenerateId(@PathVariable String generateId) {
        return this.repository.findByGenerateId(generateId);
    }

    @PutMapping("/{generateId}/edit")
    public void editTask(@PathVariable String generateId,@RequestBody Task task){
        Task currentTask=this.repository.findByGenerateId(generateId);
        currentTask.setComplete(task.getComplete());
        currentTask.setTitle(task.getTitle());
        currentTask.setUpdate_at(new Date());
        this.repository.save(currentTask);
    }

    @PutMapping("/{generateId}/complete")
    public void completeTask(@PathVariable String generateId,@RequestBody Task task) {
        Task currentTask = this.repository.findByGenerateId(generateId);
        currentTask.setComplete(true);
        this.repository.save(currentTask);
    }

    @GetMapping("/find")
    public List<Task>findComplete(@RequestParam("filter") Boolean filter){
        return repository.findByComplete(!filter);
    }
}
