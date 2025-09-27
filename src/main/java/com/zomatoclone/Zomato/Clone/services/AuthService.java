package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.SignUpRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpResponseDto;

public interface AuthService {

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

}
