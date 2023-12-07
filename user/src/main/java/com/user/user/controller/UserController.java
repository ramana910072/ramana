package com.user.user.controller;


import com.user.user.dto.UserDto;
import com.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //localhost:8083/user/post
    @PostMapping("/post")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)  {
        return new ResponseEntity<>(userService.addUser(userDto),HttpStatus.OK);
    }

    //localhost:8083/user/messages/1
    @GetMapping("/messages/{sendFrom}")
    public ResponseEntity<UserDto> getUSerWithMessages(@PathVariable("sendFrom") Integer sendFrom ){

        return new ResponseEntity<>(userService.getUserWithMessages(sendFrom), HttpStatus.OK);
    }

}
