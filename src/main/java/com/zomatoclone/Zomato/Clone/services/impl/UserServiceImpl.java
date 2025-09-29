package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.UserProfileDto;
import com.zomatoclone.Zomato.Clone.entities.User;
import com.zomatoclone.Zomato.Clone.exceptions.ResourceNotFoundException;
import com.zomatoclone.Zomato.Clone.repositories.UserRepository;
import com.zomatoclone.Zomato.Clone.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User not found with id: " + id)
                );
    }

    @Override
    public UserProfileDto getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();

        return UserProfileDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .walletBalance(user.getWallet().getBalance())
                .build();
    }
}
