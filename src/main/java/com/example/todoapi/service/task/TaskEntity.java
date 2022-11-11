package com.example.todoapi.service.task;

import lombok.Value;
import org.springframework.stereotype.Repository;

@Value
public class TaskEntity {

    long id;
    String title;

}
