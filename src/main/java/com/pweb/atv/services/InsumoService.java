package com.pweb.atv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.atv.domain.Insumo;
import com.pweb.atv.domain.Relacao;
import com.pweb.atv.repositories.InsumoRepository;
import com.pweb.atv.repositories.RelacaoRepository;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository rep;
	
	@Autowired
	private RelacaoRepository relacaoRepository;
	
//	public List<Insumo> search(String nome, List<Integer> ids) {
//		List<Relacao> insumo = relacaoRepository.findAllById(ids);
//		return rep.findDistinctByNomeContainingAndRelacaoIn(nome, insumo);
//	}
//	
//	//BUSCAR POR NOME
//	public List<Insumo> buscaPorNome(String nome){
//		return rep.findDistinctByNomeContainingAndRelacaoIn(nome, null);
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
