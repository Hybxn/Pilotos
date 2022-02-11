package com.pilotos.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pilotos.models.Monoplaza;
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
	
	@GetMapping("/monoplazas/new")
	public String newMonoplaza(Model model) {
		model.addAttribute("monoplaza", new Monoplaza());
		return "formMonoplaza";
	}
	
	@PostMapping("/monoplazas/new/submit")
	public String newMonoplazaSubmit(Monoplaza m, Model model) {
		m.setPiloto(Utils.currentPilot(ps));
		ms.insert(m);
		return "redirect:/monoplazas";
	}
	
	@GetMapping("/monoplaza/edit/{id}")
	public String editMonoplaza(Model model, @PathVariable("id") int id) {
		Monoplaza m = ms.findById(id);
		
		if (m != null) {
			model.addAttribute("monoplaza", m);
			return "formMonoplaza";			
		}
		
		return "redirect:/monoplazas";
	}
	
	@GetMapping("/monoplaza/delete/{id}")
	public String deleteMonoplaza(Model model, @PathVariable("id") int id) {
		ms.delete(id);
		
		return "redirect:/monoplazas";
	}
}
