package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.exceptions.ObjectNotFoundException;
import com.tiagoalmeida.comidaboa.repositories.RefeicaoRepository;

@Service
public class RefeicaoService extends ServiceAbstract<RefeicaoRepository, Refeicao, Integer>{
	
	@Autowired
	private RefeicaoRepository repository;
	
	@Override
	public Refeicao porId(Integer id) {
		Optional<Refeicao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Refeicao.class.getName()));
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
