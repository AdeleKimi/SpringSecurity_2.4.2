package ru.javamentor.june.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.june.models.Role;
import ru.javamentor.june.models.User;
import ru.javamentor.june.service.UserService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//
//        return "users/byIdForUser";
//    }

    @GetMapping
    public String getUser(Principal principal, Model model) {
        User user = userService.findByUserName(principal.getName());

        model.addAttribute("user", user);



        return "users/byIdForUser";
    }

}
