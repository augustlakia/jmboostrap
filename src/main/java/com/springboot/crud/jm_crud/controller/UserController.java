package com.springboot.crud.jm_crud.controller;

import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import com.springboot.crud.jm_crud.services.RoleServ;
import com.springboot.crud.jm_crud.services.UserServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserServImp userService;

	@Autowired
	private RoleServ roleServ;

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
		if (!userService.isCreated()) {
			Role rolAdmin = new Role();
			rolAdmin.setName("ROLE_ADMIN");
			roleServ.add(rolAdmin);
			Set<Role> rols = new HashSet<>();
			rols.add(roleServ.findByName("ROLE_ADMIN"));
			userService.add(new User("ADMIN", "AdminLastName", "21", "Admin@Gmail.com", "ADMIN",rols));


			Role rolUser = new Role();
			rolUser.setName("ROLE_USER");
			roleServ.add(rolUser);
			Set<Role> rols2 = new HashSet<>();
			rols2.add(roleServ.findByName("ROLE_USER"));
			userService.add(new User("USER", "UserLastName", "21", "user@gmail.com", "USER", rols2));
		}

        return "login";
    }

	@GetMapping(value = "/admin")
	public String printWelcome() {
		return "admin";
	}

}