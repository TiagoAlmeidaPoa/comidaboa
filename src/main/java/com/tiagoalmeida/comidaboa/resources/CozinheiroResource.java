package com.tiagoalmeida.comidaboa.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoalmeida.comidaboa.domain.Cozinheiro;

@RestController
@RequestMapping(value = "/cozinheiros")
public class CozinheiroResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cozinheiro> listar() {
		
		Cozinheiro coz1 = new Cozinheiro(1, "José", "85967485");
		Cozinheiro coz2 = new Cozinheiro(2, "Pedro", "96857485");
		
		List<Cozinheiro> lista = new ArrayList<>();
		lista.add(coz1);
		lista.add(coz2);
		
		return lista;
	}

}
