package com.pweb.atv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Produtos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome_produto;
	
	private Integer quantidade;
	

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "RELACAO",
		joinColumns = @JoinColumn(name = "produtos_id"),
		inverseJoinColumns = @JoinColumn(name = "insumo_id")
	)
	private List<Insumo> insumo = new ArrayList<>();
	
	public Produtos() {
		
	}
	
	public Produtos(String nome, ArrayList<Insumo> i) {
		this.nome_produto = nome;
		this.insumo = i;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public List<Insumo> getInsumo() {
		return insumo;
	}

	public void setInsumo(List<Insumo> insumo) {
		this.insumo = insumo;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome_produto == null) ? 0 : nome_produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_produto == null) {
			if (other.nome_produto != null)
				return false;
		} else if (!nome_produto.equals(other.nome_produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

}
