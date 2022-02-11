package com.pilotos.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pilotos.models.Piloto;
import com.pilotos.services.PilotoService;

@Controller
public class LoginController {

	@Autowired
	PilotoService ps;

	@GetMapping("/")
	public String landingPage() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/auth/register")
	public String registerGet(Model model) {
		model.addAttribute("piloto", new Piloto());
		return "register";
	}
	
	@PostMapping("/auth/registerSubmit")
	public String registerPost(@ModelAttribute Piloto piloto) {
		ps.insert(piloto);
		return "redirect:/auth/login";
	}
	
}
