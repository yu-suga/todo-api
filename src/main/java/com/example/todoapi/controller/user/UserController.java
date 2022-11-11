package com.example.todoapi.controller.user;


import com.example.todoapi.controller.UsersApi;
import com.example.todoapi.model.UserDTO;
import com.example.todoapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserController implements UsersApi {

    private  final UserService userService;

    @Override
    public ResponseEntity<UserDTO> showUser(Long userId) {
        var userEntity = userService.find(userId);

        var body  = new  UserDTO();
        body.setId(userEntity.getId());
        body.setName(userEntity.getName());
        body.setGenreName(userEntity.getGenreName());
        body.setLabelName(userEntity.getLabelName());

        return  ResponseEntity.ok(body);

    }
}
