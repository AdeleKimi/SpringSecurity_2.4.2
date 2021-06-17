package ru.javamentor.june.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.june.dao.UserDaoImp;
import ru.javamentor.june.models.User;
import ru.javamentor.june.service.UserServiceImp;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public UsersController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users",userServiceImp.getAll());
        return "users/AllUsers";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServiceImp.getUserById(id));

        return "users/byId";
    }

    @PostMapping()
    @Transactional
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userServiceImp.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    @Transactional
    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult,
                             @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        userServiceImp.updateUser(id,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteUser(@PathVariable("id") long id) {
        userServiceImp.deleteUser(id);
        return "redirect:/users";
    }

}
