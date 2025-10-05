package com.zomatoclone.Zomato.Clone.dto;

import com.zomatoclone.Zomato.Clone.entities.MenuItem;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private String menuName;
    private List<MenuItemDto> items;
    private boolean isActive;
}
