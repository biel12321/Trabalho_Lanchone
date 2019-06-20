package com.pweb.atv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.atv.domain.Insumo;
import com.pweb.atv.repositories.InsumoRepository;

@Service
public class InsumoService {

	@Autowired //Injetor de variavel para quando for usado.
	private InsumoRepository rep;
	
//	//BUSCA POR NOME
//	public List<Insumo> buscaPorNome(String nome){
//		return rep.findDistinctByNomeContainingOrderByNome(nome);
//	}
	
	//BUSCAR POR ID
	public Insumo find (Integer id) {
		Optional<Insumo> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Insumo insert (Insumo obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Insumo update (Insumo obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Insumo> findAll(){
		return rep.findAll();
	}
}
