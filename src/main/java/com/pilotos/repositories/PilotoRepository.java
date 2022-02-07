package com.pilotos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilotos.models.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long>{
	
	Piloto findFirstPilotoByEmail(String email);

}
