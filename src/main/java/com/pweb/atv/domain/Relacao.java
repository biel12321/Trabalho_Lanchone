package com.pweb.atv.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Relacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private RelacaoPK id = new RelacaoPK();
	
	private Integer quantidade;
	
	public Relacao(){
		
	}
	
	public Relacao(Insumo i, Produtos p, Integer qnt){
		super();
		id.setInsumo(i);
		id.setProduto(p);
		this.quantidade = qnt;
	}

	public RelacaoPK getId() {
		return id;
	}

	public void setId(RelacaoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
