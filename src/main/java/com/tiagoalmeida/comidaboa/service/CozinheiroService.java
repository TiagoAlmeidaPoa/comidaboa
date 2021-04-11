package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.exceptions.ObjectNotFoundException;
import com.tiagoalmeida.comidaboa.repositories.CozinheiroRepository;

@Service
public class CozinheiroService extends ServiceAbstract<CozinheiroRepository, Cozinheiro, Integer>{
	
	@Autowired
	private CozinheiroRepository repository;
	
	@Override
	public Cozinheiro porId(Integer id) {
		Optional<Cozinheiro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cozinheiro.class.getName()));
	}

}
