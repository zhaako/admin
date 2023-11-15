package com.spring.zhakoproject.controllers;

import com.spring.zhakoproject.entities.Items;
import com.spring.zhakoproject.entities.Person;
import com.spring.zhakoproject.repositories.ItemRepo;
import com.spring.zhakoproject.repositories.PersonRepo;
import com.spring.zhakoproject.services.ItemService;
import com.spring.zhakoproject.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Authenticator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    private PersonService personService;
    private ItemService itemService;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/signIn")
    public String sigIn(){
        return "signIn";
    }
    @GetMapping("/test2")
    public String test(Model model){
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("users", persons);
        return "test";
    }

    @GetMapping("/items")
    public String items(Model model){
        List<Items> items = itemService.getAllItem();
        model.addAttribute("items", items);
        return "Items";
    }
    @PostMapping("/addPerson")
    public String addItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                            @RequestParam(name = "item_name", defaultValue = "no item") String name,
                            @RequestParam(name = "item_price", defaultValue = "no item") int price,
                            @RequestParam(name = "item_amount", defaultValue = "0") int amount){
        itemService.addItem(new Items(id, name, price, amount));

        return "redirect:/";
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestParam(name = "id", defaultValue = "0") Long id,
                          @RequestParam(name = "person_name", defaultValue = "who") String name,
                          @RequestParam(name = "person_password", defaultValue = "") String password){
        personService.addPerson(new Person(id, name, password));

        return "redirect:/";
    }
    @PostMapping("/check")
    public String checkPerson(@RequestParam(name = "person_name") String name,
                              @RequestParam(name = "person_password") String password){
        Person person = new Person();
        if (Objects.equals(name, person.getName()) && Objects.equals(password,person.getPassword())) {
            return "redirect:/home";
        } else {
            return "redirect:/signIn";
        }
    }



}
