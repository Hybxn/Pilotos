package com.pilotos.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pilotos.services.MonoplazaService;
import com.pilotos.services.PilotoService;
import com.pilotos.utils.Utils;

@Controller
public class MonoplazaController {
	
	@Autowired
	private PilotoService ps;
	
	@Autowired
	private MonoplazaService ms;
	
	@GetMapping("/monoplazas")
	public String showMonoplazas(Model model) {
		model.addAttribute("monoplazas", ms.findByPiloto(Utils.currentPilot(ps)));
		return "listMonoplazas";
	}
}
