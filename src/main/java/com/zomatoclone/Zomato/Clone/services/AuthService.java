package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.LoginRequestDto;
import com.zomatoclone.Zomato.Clone.dto.LoginResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

    LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response);

    LoginResponseDto getAccessTokenFromRefreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
