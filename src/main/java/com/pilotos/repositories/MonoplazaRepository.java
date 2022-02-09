package com.pilotos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilotos.models.Monoplaza;
import com.pilotos.models.Piloto;

public interface MonoplazaRepository extends JpaRepository<Monoplaza, Long>{
	
	List<Monoplaza> findByPiloto(Piloto piloto);

}
