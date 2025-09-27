package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.SignUpRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpResponseDto;
import com.zomatoclone.Zomato.Clone.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        return null;
    }
}
