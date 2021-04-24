package com.tiagoalmeida.comidaboa.dto;

import java.io.Serializable;

import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.domain.Refeicao;

public class RefeicaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	private String endereco;
	private String descricao;
	private Cozinheiro cozinheiro;
	
	public RefeicaoDTO() {}

	public RefeicaoDTO(Refeicao refeicao) {
		super();
		this.id = refeicao.getId();
		this.nome = refeicao.getNome();
		this.valor = refeicao.getValor();
		this.endereco = refeicao.getEndereco();
		this.descricao = refeicao.getDescricao();
		this.cozinheiro = refeicao.getCozinheiro();	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cozinheiro getCozinheiro() {
		return cozinheiro;
	}

	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

}
