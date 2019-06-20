package com.pweb.atv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Insumo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome_insumo;
	
	private Integer quantidade_estoque;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produtos produto;
	
	public Insumo(String nome, int qnt){
		this.nome_insumo = nome;
		this.quantidade_estoque = qnt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_insumo() {
		return nome_insumo;
	}

	public void setNome_insumo(String nome_insumo) {
		this.nome_insumo = nome_insumo;
	}

	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome_insumo == null) ? 0 : nome_insumo.hashCode());
		result = prime * result + ((quantidade_estoque == null) ? 0 : quantidade_estoque.hashCode());
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
		Insumo other = (Insumo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_insumo == null) {
			if (other.nome_insumo != null)
				return false;
		} else if (!nome_insumo.equals(other.nome_insumo))
			return false;
		if (quantidade_estoque == null) {
			if (other.quantidade_estoque != null)
				return false;
		} else if (!quantidade_estoque.equals(other.quantidade_estoque))
			return false;
		return true;
	}

	
	
}
