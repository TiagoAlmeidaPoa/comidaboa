package com.tiagoalmeida.comidaboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.dto.ClienteDTO;
import com.tiagoalmeida.comidaboa.exceptions.ObjectNotFoundException;
import com.tiagoalmeida.comidaboa.repositories.ClienteRepository;

@Service
public class ClienteService extends ServiceAbstract<ClienteRepository, Cliente, Integer> {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente porId(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getTelefone());
	}
	
	
	@Override
    public Cliente editar(Cliente entidade, Integer id) {        
        try{
            entidade.setId(id);
            return repository.save(entidade);
        }catch(Exception e){
        	throw new UnexpectedRollbackException("número já esta sendo utilizado");
        }
    }
	
}
