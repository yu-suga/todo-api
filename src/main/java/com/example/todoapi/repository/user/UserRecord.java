package com.example.todoapi.repository.user;

import lombok.Value;

@Value
public class UserRecord {

    Long id;
    String name;
    String genreName;
    String labelName;
}
