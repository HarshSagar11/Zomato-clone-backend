package com.zomatoclone.Zomato.Clone.controllers;

import com.zomatoclone.Zomato.Clone.dto.LoginRequestDto;
import com.zomatoclone.Zomato.Clone.dto.LoginResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpResponseDto;
import com.zomatoclone.Zomato.Clone.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthControllers {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = authService.signUp(signUpRequestDto);
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return new ResponseEntity<>(authService.login(loginRequestDto, response), HttpStatus.OK);
    }

    @GetMapping(path = "/refresh")
    public ResponseEntity<LoginResponseDto> refreshAccessToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        return new ResponseEntity<>(authService.getAccessTokenFromRefreshToken(httpServletRequest,httpServletResponse),HttpStatus.OK);
    }

}
