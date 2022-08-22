package com.feastplanner.menuservice.controllers;

import com.feastplanner.menuservice.dao.MenuRepository;
import com.feastplanner.menuservice.dto.MenuCard;
import com.feastplanner.menuservice.exception.MenuNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Service
public class MenuController {

    @Autowired
    MenuRepository menuRepo;

    @RequestMapping("/menus/{id}")
    Optional<MenuCard> getMenuById(@PathVariable("id") Long id) {
        Optional<MenuCard> menu = menuRepo.findById(id);
        if(menu.isPresent()){
            return menu;
        }
        else {
            throw new MenuNotFound("No menu found with id: "+ id);
        }
    }

    @RequestMapping("/menus/user/{userEmail}")
    List<MenuCard>getMenuByUser(@PathVariable("userEmail") String userEmail) {
        List<MenuCard> menuList = menuRepo.findByUserEmail(userEmail);
        if(!menuList.isEmpty()){
            return menuList;
        } else {
            throw new MenuNotFound("No menu found for the user: "+ userEmail);
        }
    }

    @PostMapping("/menus")
    ResponseEntity<MenuCard> createMenu(@Valid @RequestBody MenuCard menuCard) {
        MenuCard savedMenu=menuRepo.save(menuCard);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMenu.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/menus/{id}")
    public MenuCard updateMenuCard(@Valid @RequestBody MenuCard menuCard, @PathVariable("id") Long id)
    {
        Optional<MenuCard> savedMenu = menuRepo.findById(id);
        if(savedMenu.isPresent()){
            MenuCard existingMenu = savedMenu.get();
            existingMenu.setNote(menuCard.getNote());
            existingMenu.setRecipes(menuCard.getRecipes());

            menuRepo.save(existingMenu);
            return existingMenu;
        } else{
            throw new MenuNotFound("No menu found with the id: "+ id);
        }
    }

    @DeleteMapping("/menus/{id}")
    void deleteMenuCardById(@PathVariable("id") Long id) {
        Optional<MenuCard> menu = menuRepo.findById(id);
        if(menu.isPresent()){
            MenuCard existingMenu = menu.get();
            menuRepo.delete(existingMenu);
        } else {
            throw new MenuNotFound("No menu found with the id: "+ id);
        }
    }

}
