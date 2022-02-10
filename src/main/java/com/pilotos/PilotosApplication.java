package com.pilotos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pilotos.models.Monoplaza;
import com.pilotos.models.Piloto;
import com.pilotos.repositories.MonoplazaRepository;
import com.pilotos.repositories.PilotoRepository;

@SpringBootApplication
public class PilotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotosApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initData(PilotoRepository pr, MonoplazaRepository mr) {
		return (args) ->{
			pr.save(new Piloto("ivan@prueba.com", "ivan", "Ivan", "Macia"));
			pr.save(new Piloto("Fernando@prueba.com", "fer", "Fernando", "Alonso"));
			mr.save(new Monoplaza("Red Bull PowerTrains", "RB18", 1150, pr.findById((long) 1).orElse(null)));
			mr.save(new Monoplaza("Alpine", "A521", 1250, pr.findById((long) 2).orElse(null)));
		};
	}

}
