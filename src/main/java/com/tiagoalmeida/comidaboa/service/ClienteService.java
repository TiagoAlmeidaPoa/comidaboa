package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
