package com.tiagoalmeida.comidaboa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.repositories.PedidoRepository;

@Service
public class PedidoService extends ServiceAbstract<PedidoRepository, Pedido, Integer> {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private RefeicaoService serviceRefeicao;

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Pedido> todos() {
		return (List<Pedido>) repository.findAll();
	}

	@Override
	public Pedido salvar(Pedido pedido) {
		
		try {
			if (verificaQuantidade(pedido)) {
				consomeQuantidade(pedido);
				return repository.save(pedido);				
			}

		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return null;
	}

	private void consomeQuantidade(Pedido pedido) {
		int id = pedido.getRefeicao().getId();
		Refeicao refeicao = serviceRefeicao.buscarPorId(id);
		refeicao.subtraiQuantidade();
		serviceRefeicao.editar(refeicao, id);
	}
	
	private boolean verificaQuantidade(Pedido pedido) {
		int id = pedido.getRefeicao().getId();
		Refeicao refeicao = serviceRefeicao.buscarPorId(id);
		return refeicao.getQuantidade() > 0;
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
