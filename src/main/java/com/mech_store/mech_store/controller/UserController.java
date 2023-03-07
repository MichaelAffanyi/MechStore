package com.mech_store.mech_store.controller;

import com.mech_store.mech_store.collection.User;
import com.mech_store.mech_store.repository.UserRepository;
import com.mech_store.mech_store.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userForm", new User());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/login")
    public User addUser(@Valid @ModelAttribute User user, Model model) {
        model.addAttribute("userForm", new User());

//        if(bindingResult.hasErrors()) {
//            return "index";
//        }
        return userRepository.save(user);
    }
}
