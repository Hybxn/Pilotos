package com.pilotos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilotos.models.Monoplaza;
import com.pilotos.models.Piloto;
import com.pilotos.repositories.MonoplazaRepository;

@Service
public class MonoplazaService {

	@Autowired
	MonoplazaRepository r;
	
	public Monoplaza insert(Monoplaza m) {
		return r.save(m);
	}
	
	public void delete(long id) {
		r.deleteById(id);
	}
	
	public void delete(Monoplaza m) {
		r.delete(m);
	}
	
	public Monoplaza edit(Monoplaza m) {
		return r.save(m);
	}
	
	public Monoplaza findById(long id) {
		return r.findById(id).orElse(null);
	}
	
	public List<Monoplaza> findAll(){
		return r.findAll();
	}
	
	public List<Monoplaza> findByPiloto(Piloto p){
		return r.findByPilto(p);
	}
}
