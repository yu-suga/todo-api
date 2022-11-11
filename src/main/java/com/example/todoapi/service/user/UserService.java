package com.example.todoapi.service.user;

import com.example.todoapi.repository.user.UserRepository;
import com.example.todoapi.service.task.TaskEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserEntity find(Long userId) {
        return userRepository.select(userId)
                .map(record -> new UserEntity(record.getId(),record.getName(),record.getGenreName(),record.getLabelName()))
                .orElseThrow(() -> new TaskEntityNotFoundException(userId));
    }
}
