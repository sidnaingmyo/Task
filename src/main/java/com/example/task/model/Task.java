package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String generateId;
    private String title;
    private Boolean complete;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_at;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date update_at;
    @annotation
    private String email;

    private String payment;



}
