package com.tiagoalmeida.comidaboa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.service.CozinheiroService;

@RestController
@RequestMapping(value = "/cozinheiros")
public class CozinheiroResource {

	@Autowired
	private CozinheiroService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cozinheiro obj = service.porId(id);
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Cozinheiro cozinheiro, @PathVariable Integer id) {
		cozinheiro = service.editar(cozinheiro, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<Cozinheiro>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Cozinheiro> pages = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(pages);
	}

}
