package com.tiagoalmeida.comidaboa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.service.CozinheiroService;

@RestController
@RequestMapping(value = "/cozinheiros")
public class CozinheiroResource {

	@Autowired
	private CozinheiroService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cozinheiro obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/todos")
	@ResponseBody
	public List<Cozinheiro> todosCozinheiros() {
		return service.todos();
	}
	
	@PostMapping(value = "/novo")
    public Cozinheiro salvar(@RequestBody Cozinheiro cozinheiro) {
        return service.salvar(cozinheiro);
    }

}
