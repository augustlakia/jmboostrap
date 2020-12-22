package com.springboot.crud.jm_crud.controller;

import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import com.springboot.crud.jm_crud.services.UserServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class FinishedUserController {

    @Autowired
    private UserServImp userService;

//
//    @GetMapping(value = "/first")
//    public String bd() {
//        List<Role> rols = new ArrayList<>();
//        rols.add(new Role("ROLE_ADMIN"));
//        userService.add(new User("ADMIN", "admin@admin.com", "ADMIN", rols));
//        List<Role> rols2 = new ArrayList<>();
//        rols2.add(new Role("ROLE_USER"));
//        userService.add(new User("USER", "user@user.com", "USER", rols2));
//        return "first";
//    }

@GetMapping(value = "/user")
public String aboutUser(Model model, Authentication auth) {
    User loggedUser = (User) auth.getPrincipal();
    model.addAttribute("user",loggedUser);
    return "user";
}

    @GetMapping(value = "/admin")
    public String printWelcome(Model model, Authentication auth) {
        User loggedUser = (User) auth.getPrincipal();
        model.addAttribute("userl",loggedUser);
        model.addAttribute("users", userService.getUsersList());
        return "index";
    }

    @GetMapping("admin/user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        System.out.println(userService.findById(id));
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("admin/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }


    // changed not working on admin
    @PostMapping("/admin")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping("admin/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.Update(user);
        return "redirect:/admin";
    }
    @DeleteMapping("admin/user/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.Delete(id);
        return "redirect:/admin";
    }

}

