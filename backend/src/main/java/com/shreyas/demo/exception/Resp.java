package com.shreyas.demo.exception;

import java.util.List;
import com.shreyas.demo.model.Task;

public class Resp {
    private String message;
    private List<Task> tasks;

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public List<Task> getTasks(){
        return tasks;
    }
     public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
