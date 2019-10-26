package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


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

    public Task() {
    }

    public Task(String generateId, String title, Boolean complete, Date create_at, Date update_at) {
        this.generateId = generateId;
        this.title = title;
        this.complete = complete;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenerateId() {
        return generateId;
    }

    public void setGenerateId(String generateId) {
        this.generateId = generateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
