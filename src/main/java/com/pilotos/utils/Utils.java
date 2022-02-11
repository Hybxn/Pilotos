package com.pilotos.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pilotos.models.Piloto;
import com.pilotos.services.PilotoService;

public class Utils {
	
	public static Piloto currentPilot(PilotoService ps) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails) auth.getPrincipal();
		Piloto p = ps.findByEmail(ud.getUsername());
		
		return p;				
	}

}
