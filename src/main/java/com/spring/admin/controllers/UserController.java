package com.spring.admin.controllers;


import java.security.Principal;
import java.util.List;

import com.spring.admin.dto.UserDto;
import com.spring.admin.entities.Item;
import com.spring.admin.services.ItemService;
import com.spring.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userDto.setRole("USER");
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully!");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }

    @GetMapping("/items")
    public String items(Model model){
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items";
    }
    @PostMapping("/addItem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "null") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price){
        Item items = new Item();
        items.setName(name);
        items.setPrice(price);
        itemService.addItem(items);
        return "redirect:/items";
    }

    @GetMapping("/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        Item item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "details";
    }

    @PostMapping("/deleteitem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id){
        Item item = itemService.getItem(id);
        if(item!=null){
            itemService.deleteItem(item);
        }
        return "redirect:/items";
    }

    @PostMapping("/saveitem")
    public String saveItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                           @RequestParam(name = "name", defaultValue = "no item") String name,
                           @RequestParam(name = "price", defaultValue = "0") int price){
        Item item = itemService.getItem(id);
        if(item!=null){
            item.setName(name);
            item.setPrice(price);
            itemService.saveItem(item);
        }
        return "redirect:/items";
    }
}
