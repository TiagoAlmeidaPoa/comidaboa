package com.tiagoalmeida.comidaboa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.repositories.ClienteRepository;
import com.tiagoalmeida.comidaboa.repositories.CozinheiroRepository;

@SpringBootApplication
public class ProjetocomidaboaApplication implements CommandLineRunner{
	
	@Autowired
	private CozinheiroRepository cozinheiroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetocomidaboaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cozinheiro coz1 = new Cozinheiro(null, "Pedro", "96857485");
		Cozinheiro coz2 = new Cozinheiro(null, "João", "85749685");
		
		Cliente cli1 = new Cliente(null, "Neiva", "96857489");
		Cliente cli2 = new Cliente(null, "Vania", "89748596");
		
		cozinheiroRepository.saveAll(Arrays.asList(coz1,coz2));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		
	}

}
