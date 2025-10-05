package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.entities.MenuItem;

public interface MenuItemService {
    MenuItem getMenuItemByIdToAddInCart(Long menuItemId);
}
