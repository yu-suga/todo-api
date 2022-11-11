package com.example.todoapi.controller.advice;

import com.example.todoapi.model.ResourceNotFoundError;
import com.example.todoapi.service.task.TaskEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(TaskEntityNotFoundException.class)
    public ResponseEntity<Void> handleTaskEntityNotFoundException(TaskEntityNotFoundException e){
        var error = new ResourceNotFoundError();
        error.setDetail(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
