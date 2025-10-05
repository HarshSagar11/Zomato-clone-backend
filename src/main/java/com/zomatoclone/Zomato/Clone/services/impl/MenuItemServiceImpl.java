package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.MenuItem;
import com.zomatoclone.Zomato.Clone.exceptions.BadRequestException;
import com.zomatoclone.Zomato.Clone.exceptions.ResourceNotFoundException;
import com.zomatoclone.Zomato.Clone.repositories.MenuItemRepository;
import com.zomatoclone.Zomato.Clone.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public MenuItem getMenuItemByIdToAddInCart(Long menuItemId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow(
                ()-> new ResourceNotFoundException("Menu Item not found with id : "+ menuItemId)
        );
        if(!menuItem.isAvailable()){
            throw new BadRequestException("This item is not available right now");
        }
        return menuItem;
    }
}
