package com.tunehub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.Entity.Users;
import com.tunehub.Services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/registration")
	public String addUser(@ModelAttribute Users user) {
		boolean user_status = service.exitsEmail(user.getEmail());
		if (user_status == false) {
			service.addUser(user);
		} else {
			System.out.println("email id is already register.");
		}
		return "home";

	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password) {
		if (service.validateUser(email, password) == true) {
			String role = service.getRole(email);
			if (role.equals("admin")) {
				return "adminHome";

			} else {
				return "customerHome";
			}

		} else {
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
