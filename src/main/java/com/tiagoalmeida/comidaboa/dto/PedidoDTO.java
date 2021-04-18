package com.tiagoalmeida.comidaboa.dto;

import java.io.Serializable;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private RefeicaoDTO refeicaoDTO;
	private Cliente cliente;
	
	public PedidoDTO() {}
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.refeicaoDTO = criaRefeicaoDTO(pedido.getRefeicao());		
		this.cliente = pedido.getCliente();
	}
	
	public RefeicaoDTO criaRefeicaoDTO(Refeicao refeicao) {
		return new RefeicaoDTO(refeicao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RefeicaoDTO getRefeicaoDTO() {
		return refeicaoDTO;
	}

	public void setRefeicaoDTO(RefeicaoDTO refeicaoDTO) {
		this.refeicaoDTO = refeicaoDTO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
