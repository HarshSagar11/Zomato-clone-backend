package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.UserProfileDto;
import com.zomatoclone.Zomato.Clone.entities.User;

public interface UserService {
    User getUserById(Long id);

    UserProfileDto getUserProfile();
}
