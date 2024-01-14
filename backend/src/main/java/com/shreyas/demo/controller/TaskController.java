package com.shreyas.demo.controller;

import com.shreyas.demo.model.Task;
// import com.shreyas.demo.exception.Response;
import com.shreyas.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.server.ResponseStatusException;
import com.shreyas.demo.exception.Resp;

import java.util.List;
import java.util.Optional;


//API requests

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Resp> getTasksByName(@PathVariable String name) {
        List<Task> tasks = taskService.getTaskByName(name);
    
        Resp response = new Resp();
        if (tasks.isEmpty()) {
            // return ResponseEntity.notFound().build();
             response.setMessage("Record not found!");   
             return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.setMessage("Task retrieved successfully!");
        response.setTasks(tasks);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
public ResponseEntity<Task> createTask(@RequestBody Task task) {
    task.setcandidateName(task.getcandidateName());

    Task createdTask = taskService.createTask(task);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
      
        System.out.println(id);
        taskService.deleteTask(id);
        String response = "Task with ID:" + id + " deleted successfully!"; 
        return ResponseEntity.ok(response);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
         Optional<Task> existingTask = taskService.getTaskById(id);

         if(existingTask.isPresent()){
            Task savedTask = taskService.updateTask(id,updatedTask);

            return ResponseEntity.ok(savedTask);
         }
         else {
            return ResponseEntity.notFound().build();
        }
        
    }

}
