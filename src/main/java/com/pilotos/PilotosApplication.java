package com.pilotos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pilotos.models.Monoplaza;
import com.pilotos.models.Piloto;
import com.pilotos.services.MonoplazaService;
import com.pilotos.services.PilotoService;

@SpringBootApplication
public class PilotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotosApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initData(PilotoService ps, MonoplazaService ms) {
		return (args) ->{
			ps.insert(new Piloto("ivan@prueba.com", "ivan", "Ivan", "Macia"));
			ps.insert(new Piloto("Fernando@prueba.com", "fer", "Fernando", "Alonso"));
			ms.insert(new Monoplaza("Red Bull PowerTrains", "RB18", 1150, ps.findById(1)));
			ms.insert(new Monoplaza("Alpine", "A521", 1250, ps.findById(2)));
		};
	}

}
