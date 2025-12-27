// THIS CODE IS WRITTEN BY NITU

package com.timetracker.model;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class TimeLog {
    private int id;
    private int userId;
    private String task;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double hours;
    private LocalDate dateLogged;
    private String notes;

    public TimeLog() {}

    public TimeLog(int userId, String task, LocalDateTime startTime, LocalDateTime endTime, double hours, LocalDate dateLogged, String notes) {
        this.userId = userId;
        this.task = task;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hours = hours;
        this.dateLogged = dateLogged;
        this.notes = notes;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public double getHours() { return hours; }
    public void setHours(double hours) { this.hours = hours; }
    public LocalDate getDateLogged() { return dateLogged; }
    public void setDateLogged(LocalDate dateLogged) { this.dateLogged = dateLogged; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}


