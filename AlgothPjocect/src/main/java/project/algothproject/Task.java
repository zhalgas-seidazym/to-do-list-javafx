package project.algothproject;

import javafx.scene.control.Alert;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Task implements Serializable, Comparable<Task>{
    private String description;
    private String details;
    private LocalDate date;
    private String time;

    public Task(){}

    public Task(String description, String details, LocalDate date, String time) {
        this.description = description;
        this.details = details;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Task o) {
        return this.getTime().compareTo(o.getTime());
    }
}


