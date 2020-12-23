package com.springboot.crud.jm_crud.controller;

import com.springboot.crud.jm_crud.DAO.RoleDAOImp;
import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import com.springboot.crud.jm_crud.services.RoleServImp;
import com.springboot.crud.jm_crud.services.UserServ;
import com.springboot.crud.jm_crud.services.UserServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api")
public class FinishedUserController {

    @Autowired
    private UserServImp userService;

    @Autowired
    private RoleServImp roleServImp;

    @GetMapping(value = "/allUsers")
    public List<User> printWelcome() {
        List<User> as = userService.getUsersList();
        return as;
    }

    @GetMapping(value = "get/{id}")
    public User show(@PathVariable("id") int id) {
        return userService.findById(id);
    }




    @PutMapping(value = "/{id}")
    public String update(@RequestBody User user, @PathVariable("id") int id) {

        if (user.getRol().equals("Admin")) {
            Role toSet = roleServImp.findByName("ROLE_ADMIN");
            Set<Role> setOfRoles = new HashSet<>();
            setOfRoles.add(toSet);
            user.setRoles(setOfRoles);
        }
        if (user.getRol().equals("User")) {
            Role toSet = roleServImp.findByName("ROLE_USER");
            Set<Role> setOfRoles = new HashSet<>();
            setOfRoles.add(toSet);
            user.setRoles(setOfRoles);
        }
        if (user.getRol().equals("UserAdmin")) {
            Role toSet = roleServImp.findByName("ROLE_ADMIN");
            Role toSet2 = roleServImp.findByName("ROLE_USER");
            Set<Role> setOfRoles = new HashSet<>();
            setOfRoles.add(toSet);
            setOfRoles.add(toSet2);
            user.setRoles(setOfRoles);
        }
        userService.Update(user);
        return "redirect:/admin";
    }




}


//
//    @PostMapping("/new")
//    public String create(@ModelAttribute("user") User user) {
//
//        if (user.getRolesString().equals("Admin")) {
//            Role toSet = roleServImp.findByName("ROLE_ADMIN");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            user.setRoles(setOfRoles);
//        }
//        if (user.getRolesString().equals("User")) {
//            Role toSet = roleServImp.findByName("ROLE_USER");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            user.setRoles(setOfRoles);
//        }
//        if (user.getRolesString().equals("UserAdmin")) {
//            Role toSet = roleServImp.findByName("ROLE_ADMIN");
//            Role toSet2 = roleServImp.findByName("ROLE_USER");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            setOfRoles.add(toSet2);
//            user.setRoles(setOfRoles);
//        }
//
//        userService.add(user);
//        return "redirect:/admin";
//    }
//





//@Controller
//public class FinishedUserController {
//
//    @Autowired
//    private UserServImp userService;
//
////
////    @GetMapping(value = "/first")
////    public String bd() {
////        List<Role> rols = new ArrayList<>();
////        rols.add(new Role("ROLE_ADMIN"));
////        userService.add(new User("ADMIN", "admin@admin.com", "ADMIN", rols));
////        List<Role> rols2 = new ArrayList<>();
////        rols2.add(new Role("ROLE_USER"));
////        userService.add(new User("USER", "user@user.com", "USER", rols2));
////        return "first";
////    }
//
//    @Autowired
//    RoleDAOImp roleDAOImp;
//
//@GetMapping(value = "/user")
//public String aboutUser(Model model, Authentication auth) {
//    User loggedUser = (User) auth.getPrincipal();
//    model.addAttribute("user",loggedUser);
//    return "user";
//}
//

//
//    @GetMapping("admin/user/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        System.out.println(userService.findById(id));
//        model.addAttribute("user", userService.findById(id));
//        return "show";
//    }
//
//    @GetMapping("admin/new")
//    public String newPerson(@ModelAttribute("user") User user) {
//        return "new";
//    }
//
//
//    // changed not working on admin
//    @PostMapping("/admin")
//    public String create(@ModelAttribute("user") User user) {
//
//        if(user.getRolesString().equals("Admin")) {
//            Role toSet = roleDAOImp.findByName("ROLE_ADMIN");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            user.setRoles(setOfRoles);
//        }
//        if(user.getRolesString().equals("User")) {
//            Role toSet = roleDAOImp.findByName("ROLE_USER");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            user.setRoles(setOfRoles);
//        }
//        if (user.getRolesString().equals("UserAdmin")) {
//            Role toSet = roleDAOImp.findByName("ROLE_ADMIN");
//            Role toSet2 = roleDAOImp.findByName("ROLE_USER");
//            Set<Role> setOfRoles = new HashSet<>();
//            setOfRoles.add(toSet);
//            setOfRoles.add(toSet2);
//            user.setRoles(setOfRoles);
//        }
//
//
//
//        userService.add(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.findById(id));
//        return "edit";
//    }
//

//    @DeleteMapping("admin/user/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.Delete(id);
//        return "redirect:/admin";
//    }
//
//}

