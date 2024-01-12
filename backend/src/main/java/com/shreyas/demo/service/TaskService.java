package com.shreyas.demo.service;


// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import com.shreyas.demo.exception.ResourceNotFoundException;
import com.shreyas.demo.model.Task;
import com.shreyas.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    // private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTaskByName(String name){
        return taskRepository.findByName(name);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);   
    }

    public void deleteTask(String id) {

        taskRepository.deleteById(id);
        
    }
    

    public Task updateTask(String id, Task updatedTask){

        Optional<Task> existingTask = taskRepository.findById(id);
        
        if(existingTask.isPresent()){
            Task taskToUpdate = existingTask.get();
            
            taskToUpdate.setcandidateName(updatedTask.getcandidateName());
            taskToUpdate.setassignee(updatedTask.getassignee());
            taskToUpdate.setproject(updatedTask.getproject());
            taskToUpdate.setStartTime(updatedTask.getstartTime());

            return taskRepository.save(taskToUpdate);
        }

    else {
        throw new ResourceNotFoundException("Task not found with id: " + id);
    }
   
   
    
    }
}
