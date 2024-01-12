package com.shreyas.demo.repository;

import com.shreyas.demo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List; 

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByName(String name);
    List<Task> findFirst10ByAssigneeOrderByStartTime(String assignee);
    
}


