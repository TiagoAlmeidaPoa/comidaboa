package com.tiagoalmeida.comidaboa.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.dto.ClienteDTO;
import com.tiagoalmeida.comidaboa.dto.PedidoDTO;
import com.tiagoalmeida.comidaboa.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.porId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> findAll() {
		List<Pedido> list = service.todos();
		List<PedidoDTO> listDTO = list.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping(value = "/novo")
    public Pedido save(@RequestBody Pedido pedido) {
        return service.salvar(pedido);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable Integer id) {
		pedido = service.editar(pedido, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<PedidoDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "cliente.nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Pedido> pages = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PedidoDTO> pagesDTO = pages.map(obj -> new PedidoDTO(obj));
		return ResponseEntity.ok().body(pagesDTO);
	}

}
