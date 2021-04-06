package com.tiagoalmeida.comidaboa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.repositories.PedidoRepository;

@Service
public class PedidoService extends ServiceAbstract<PedidoRepository, Pedido, Integer> {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Pedido> todos() {
		return (List<Pedido>) repository.findAll();
	}
	


}
