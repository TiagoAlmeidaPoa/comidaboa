package com.tiagoalmeida.comidaboa.dto;

import java.io.Serializable;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Refeicao refeicao;
	private Cliente cliente;
	
	public PedidoDTO() {}
	
	public PedidoDTO(Pedido pedido) {
		Refeicao refeicao = pedido.getRefeicao();
		Refeicao refeicao1 = new Refeicao(refeicao.getId(), refeicao.getNome(), refeicao.getValor(), refeicao.getEndereco(), refeicao.getCozinheiro());
		this.id = pedido.getId();
		this.refeicao = null;
		this.cliente = null;
	}
	
	

//	public PedidoDTO(Pedido pedido) {
//		this.id = pedido.getId();
//		this.refeicao = pedido.getRefeicao();
//		this.cliente = pedido.getCliente();
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

}
