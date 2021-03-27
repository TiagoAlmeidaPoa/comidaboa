package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {
	
	@Autowired
	private RefeicaoRepository repository;
	
	public Refeicao buscarPorId(Integer id) {
		Optional<Refeicao> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
