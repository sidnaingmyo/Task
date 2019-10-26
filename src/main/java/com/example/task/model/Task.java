package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String generateId;
    private String title;
    private boolean complete;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_at;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate update_at;

    public Task(String generateId, String title, boolean complete, LocalDate create_at, LocalDate update_at) {
        this.generateId = generateId;
        this.title = title;
        this.complete = complete;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Task() {
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public LocalDate getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }

    //  public Date convertToDate(LocalDate localDate)throws Exception{
    //    return new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
    //}
}
