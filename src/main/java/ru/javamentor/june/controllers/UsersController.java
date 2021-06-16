package ru.javamentor.june.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.june.dao.UserDaoImp;
import ru.javamentor.june.models.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDaoImp userDaoImp;

    @Autowired
    public UsersController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users",userDaoImp.getAll());
        return "users/AllUsers";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDaoImp.getUserById(id));

        return "users/byId";
    }

    @PostMapping()
    @Transactional
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userDaoImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userDaoImp.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    @Transactional
    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult,
                             @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        userDaoImp.updateUser(id,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteUser(@PathVariable("id") long id) {
        userDaoImp.deleteUser(id);
        return "redirect:/users";
    }

}
