package com.mech_store.mech_store.controller;

import com.mech_store.mech_store.collection.User;
import com.mech_store.mech_store.repository.UserRepository;
import com.mech_store.mech_store.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @GetMapping ("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/login")
    public String addUser(@Valid @ModelAttribute User user, Model model, Errors errors) {
        if(errors.hasErrors()) {
            return "index";
        }
        else {
            model.addAttribute("userForm", new User());
            userRepository.save(user);
            return "login";
        }

//        if(bindingResult.hasErrors()) {
//            return "index";
//        }
//        return userRepository.save(user);
    }

    @GetMapping("/getusername")
    public List<User> findUserByUsername(@RequestParam("username") String username) {
        return userRepository.findByUsername(username);
    }

//    @PostMapping("/dashboard")
//    public String dashboard(@Valid @ModelAttribute User user, Model model) {
//        model.addAttribute("loginForm", new User());
//        List<User> username = userRepository.findUserByUsername(user.getUsername());
//        System.out.println(username);
//        return "dashboard";
//    }
}
