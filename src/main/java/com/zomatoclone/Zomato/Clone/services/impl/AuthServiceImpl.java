package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.LoginRequestDto;
import com.zomatoclone.Zomato.Clone.dto.LoginResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SignUpResponseDto;
import com.zomatoclone.Zomato.Clone.entities.User;
import com.zomatoclone.Zomato.Clone.entities.Wallet;
import com.zomatoclone.Zomato.Clone.entities.enums.Roles;
import com.zomatoclone.Zomato.Clone.exceptions.BadRequestException;
import com.zomatoclone.Zomato.Clone.exceptions.ResourceNotFoundException;
import com.zomatoclone.Zomato.Clone.repositories.UserRepository;
import com.zomatoclone.Zomato.Clone.security.JwtService;
import com.zomatoclone.Zomato.Clone.services.AuthService;
import com.zomatoclone.Zomato.Clone.services.CustomerService;
import com.zomatoclone.Zomato.Clone.services.WalletService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerService customerService;
    private final WalletService walletService;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;


    @Override
    @Transactional
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        boolean isUserExistByEmail = userRepository.existsByEmail(signUpRequestDto.getEmail());
        if(isUserExistByEmail){
            throw new RuntimeException("User already exist with email: " + signUpRequestDto.getEmail());
        }
        String password = passwordEncoder.encode(signUpRequestDto.getPassword());
        User mappedUser = modelMapper.map(signUpRequestDto, User.class);
        mappedUser.setPassword(password);
        mappedUser.setRole(Set.of(Roles.CUSTOMER));
        Wallet wallet = walletService.createWallet();
        mappedUser.setWallet(wallet);
        User savedUser = userRepository.save(mappedUser);
        customerService.createCustomerFromUser(savedUser);
        return modelMapper.map(savedUser, SignUpResponseDto.class);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not Found with email: " + loginRequestDto.getEmail())
                );
        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
            throw new BadRequestException("Entered password was incorrect");
        }
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        Cookie cookie = new Cookie("refresh_token", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(1000*60*60*24*7);
        response.addCookie(cookie);

        return LoginResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }

    @Override
    public LoginResponseDto getAccessTokenFromRefreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String refreshToken = Arrays.stream(httpServletRequest.getCookies())
                .filter(cookie1 -> cookie1.getName().equals("refresh_token"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BadRequestException("Refresh token error. Please login again")
        );
        String accessToken = jwtService.generateAccessToken(user);
        return LoginResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
