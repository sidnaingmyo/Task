package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public Task create(Task task) {
        task.setGenerateId(RandomStringUtils.randomAlphanumeric(12));
        task.setCreate_at(new Date());
        //Task findtitle= repository.findByTitle(task.getTitle());
        //   if(findtitle != null) throw new AlreadyExistException("Title is already Exists");
//        Task findemail = repository.findByEmail(task.getEmail());
//        if(findemail != null) throw new RuntimeException("Email already Exist");
        task.setEncryptedPassword(bCryptPasswordEncoder.encode(task.getPassword()));
        return this.taskRepository.save(task);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Task task=taskRepository.findByEmail(email);
        if(task==null){
            throw new UsernameNotFoundException(email);
        }
        return new User(task.getEmail(),task.getEncryptedPassword(),new ArrayList<>());

    }
}
