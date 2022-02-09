package com.pilotos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pilotos.models.Piloto;
import com.pilotos.repositories.PilotoRepository;

@Service
public class PilotoService {

	@Autowired
	PilotoRepository r;
	
	@Autowired
	BCryptPasswordEncoder passEnc;
	
	
	public Piloto insert(Piloto p) {
		p.setPassword(passEnc.encode(p.getPassword()));
		return r.save(p);
	}
	
	public Piloto findById(long id) {
		return r.findById(id).orElse(null);
	}
	
	public Piloto findByEmail(String e) {
		return r.findFirstPilotoByEmail(e);
	}
}
