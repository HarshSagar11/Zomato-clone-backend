package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.Menu;
import com.zomatoclone.Zomato.Clone.repositories.MenuRepository;
import com.zomatoclone.Zomato.Clone.services.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public List<Menu> getMenuOfRestaurant(Long restaurantId) {
        log.info("Getting menus of restaurant with id : {}", restaurantId);
        return menuRepository.findAllByRestaurantId(restaurantId);
    }
}
