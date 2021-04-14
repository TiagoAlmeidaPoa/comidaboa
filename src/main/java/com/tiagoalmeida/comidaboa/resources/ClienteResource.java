package com.tiagoalmeida.comidaboa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.dto.ClienteDTO;
import com.tiagoalmeida.comidaboa.service.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/clientes")
@Tag(name = "clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id) {
		Cliente obj = service.porId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/todos")
	@ResponseBody
	public List<Cliente> todosClientes() {
		return service.todos();
	}
	
//	@PostMapping(value = "/novo")
//    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
//        return service.salvar(cliente);
//    }
	
	@RequestMapping(value = "/novo", method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteDTO objDto) {
		Cliente obj = service.fromDTO(objDto);
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "editar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
		Cliente cliente = service.fromDTO(clienteDTO);
		cliente = service.editar(cliente, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
