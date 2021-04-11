package com.tiagoalmeida.comidaboa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoalmeida.comidaboa.domain.EntityAbstract;
import com.tiagoalmeida.comidaboa.exceptions.DataIntegrityException;
import com.tiagoalmeida.comidaboa.exceptions.ObjectNotFoundException;

public abstract class ServiceAbstract<
		R extends JpaRepository<E, T>,
		E extends EntityAbstract<T>, T> {
	
	@Autowired
	protected R repository;
	
	
	public E salvar(E entidade) {
		try {
			return repository.save(entidade);
		}catch(Exception e){
            e.getMessage();
            return null;
        }
	}
	
	
    public E editar(E entidade, T id) {        
        try{
            entidade.setId(id);
            return repository.save(entidade);
        }catch(Exception e){
        	e.getMessage();
            return null;
        }
    }
    
    public List<E> todos(){
        return (List<E>) repository.findAll();
    }
    
    public E porId(T id) {
		Optional<E> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id ));
	}
    
    public void delete(T id) {
    	try {
    		repository.deleteById(id);
    	}catch(DataIntegrityViolationException e) {
    		throw new DataIntegrityException("Não é possivel excluir um dado que esta sendo usado");
    	}catch(EmptyResultDataAccessException e) {
    		throw new ObjectNotFoundException("Id: "+id+" não encontrado no banco de dados");
    	}
		
	}

}
