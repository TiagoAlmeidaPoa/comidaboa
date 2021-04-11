package com.tiagoalmeida.comidaboa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.exceptions.ObjectNotFoundException;
import com.tiagoalmeida.comidaboa.repositories.PedidoRepository;

@Service
public class PedidoService extends ServiceAbstract<PedidoRepository, Pedido, Integer> {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private RefeicaoService serviceRefeicao;
	
	@Override
	public Pedido porId(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public List<Pedido> todos() {
		return (List<Pedido>) repository.findAll();
	}

	@Override
	public Pedido salvar(Pedido pedido) {
	
			if (verificaQuantidade(pedido)) {
				consomeQuantidade(pedido);
				Refeicao refeicao = pedido.getRefeicao();
				Refeicao refeicao1 = new Refeicao(refeicao.getId(), refeicao.getNome(), refeicao.getValor(), refeicao.getEndereco(), refeicao.getCozinheiro());
				pedido.setRefeicao(refeicao1);
				return repository.save(pedido);				
			} else {
				throw new ObjectNotFoundException("Refeição esgotada...");
			}
	}

	private void consomeQuantidade(Pedido pedido) {
		int id = pedido.getRefeicao().getId();
		Refeicao refeicao = serviceRefeicao.porId(id);
		refeicao.subtraiQuantidade();
		serviceRefeicao.editar(refeicao, id);
	}
	
	private boolean verificaQuantidade(Pedido pedido) {
		int id = pedido.getRefeicao().getId();
		Refeicao refeicao = serviceRefeicao.porId(id);
		return refeicao.getQuantidade() > 0;
	}

}
