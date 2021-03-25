package com.tiagoalmeida.comidaboa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.repositories.CozinheiroRepository;

@SpringBootApplication
public class ProjetocomidaboaApplication implements CommandLineRunner{
	
	@Autowired
	private CozinheiroRepository cozinheiroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetocomidaboaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cozinheiro coz1 = new Cozinheiro(null, "Pedro", "96857485");
		Cozinheiro coz2 = new Cozinheiro(null, "João", "85749685");
		
		cozinheiroRepository.saveAll(Arrays.asList(coz1,coz2));
		
	}

}
