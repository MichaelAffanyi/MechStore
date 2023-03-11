package com.mech_store.mech_store.controller;

import com.mech_store.mech_store.collection.Products;
import com.mech_store.mech_store.collection.Purchase;
import com.mech_store.mech_store.collection.User;
import com.mech_store.mech_store.repository.ProductRepository;
import com.mech_store.mech_store.repository.UserRepository;
import com.mech_store.mech_store.service.UserService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    private UserService userService;

    @GetMapping("/")
    public String index( Model model) {
        model.addAttribute("userForm", new User());
        return "index";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("loginForm", new User());
        model.addAttribute("userForm");
        return "login";
    }

    @GetMapping("/purchase_product")
    public String purchase_product(){
        return "purchase_product";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping ("/dashboard")
    public String dashboard(Model model) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("buy", new Purchase());
//        System.out.println(products);
        return "dashboard";
    }

    @PostMapping("/login")
    public String addUser(@Valid @ModelAttribute User user, Errors errors, Model model) {
//        model.addAttribute("userForm", new User());
        if(errors.hasErrors()) {
            model.addAttribute("userForm", new User());
           return "redirect:/";
        }
        else {
//            model.addAttribute("userForm", new User());
            userRepository.save(user);
            return "login";
        }

    }

    @GetMapping("/getusername")
    public List<User> findUserByUsername(@RequestParam("username") String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("/dashboard")
    public String dashboard(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        model.addAttribute("loginForm", new User());
        List<User> userDoc = userRepository.findByUsername(user.getUsername());
        String password = userDoc.get(0).getPassword();
//        System.out.println(user.getPassword());
        if(Objects.equals(user.getPassword(), password)) {
            return "dashboard";
        }
        else {
            bindingResult.addError(new FieldError("loginForm", "password", "Invalid Credentials"));
            return "redirect:/login";
        }
    }

    @PostMapping("/buy")
    public String purchase(@ModelAttribute Purchase purchase, Model model) {
        model.addAttribute("buy", new Purchase());
        System.out.println(purchase.getAmount());
        return null;
    }
}
