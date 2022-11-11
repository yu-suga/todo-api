package com.example.todoapi.service.user;

import lombok.Value;

@Value
public class UserEntity {

    long id;
    String name;
    String genreName;
    String labelName;
}
