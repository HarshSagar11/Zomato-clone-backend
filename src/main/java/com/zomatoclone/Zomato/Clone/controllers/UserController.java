package com.zomatoclone.Zomato.Clone.controllers;

import com.zomatoclone.Zomato.Clone.dto.UserProfileDto;
import com.zomatoclone.Zomato.Clone.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(){
        return new ResponseEntity<>(userService.getUserProfile(), HttpStatus.OK);
    }
}
