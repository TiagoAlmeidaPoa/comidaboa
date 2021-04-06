package com.tiagoalmeida.comidaboa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoalmeida.comidaboa.domain.EntityAbstract;

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
    
    public E porId(T id){        
        try{
            return repository.findById(id).get();
        }catch(Exception e){
            return null;
        }
    }

}
