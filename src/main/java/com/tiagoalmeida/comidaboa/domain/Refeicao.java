package com.tiagoalmeida.comidaboa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Refeicao extends EntityAbstract<Integer> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double valor;
	private String endereco;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "cozinheiro_id")
	private Cozinheiro cozinheiro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "refeicao")
	private List<Pedido> pedidos = new ArrayList<>();
			
	public Refeicao() {}

	public Refeicao(Integer id, String nome, Double valor, String endereco, Integer quantidade, Cozinheiro cozinheiro) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.endereco = endereco;
		this.quantidade = quantidade;
		this.cozinheiro = cozinheiro;
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
		
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void subtraiQuantidade() {
		this.quantidade = quantidade - 1;
	}

	public Cozinheiro getCozinheiro() {
		return cozinheiro;
	}

	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}
	
	

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		

}
