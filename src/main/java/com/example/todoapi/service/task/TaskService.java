package com.example.todoapi.service.task;

import com.example.todoapi.repository.task.TaskRecord;
import com.example.todoapi.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskEntity find(Long taskId) {
    return taskRepository.select(taskId)
            .map(record -> new TaskEntity(record.getId(), record.getTitle()))
            .orElseThrow(() -> new TaskEntityNotFoundException(taskId));
    }
    public TaskEntity create(String title) {
        var record = new TaskRecord(null,title);

        taskRepository.insert(record);
        return new TaskEntity(record.getId(), record.getTitle());
    }
}
