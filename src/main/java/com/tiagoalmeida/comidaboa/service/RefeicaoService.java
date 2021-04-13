package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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
	
	public Page<Refeicao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}	

}
