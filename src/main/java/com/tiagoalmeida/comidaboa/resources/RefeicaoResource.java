package com.tiagoalmeida.comidaboa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.service.CozinheiroService;
import com.tiagoalmeida.comidaboa.service.RefeicaoService;

@RestController
@RequestMapping(value = "/refeicoes")
public class RefeicaoResource {

	@Autowired
	private RefeicaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Refeicao obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

}
