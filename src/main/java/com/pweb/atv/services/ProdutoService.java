package com.pweb.atv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.atv.domain.Insumo;
import com.pweb.atv.domain.Produtos;
import com.pweb.atv.repositories.InsumoRepository;
import com.pweb.atv.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	//BUSCAR POR ID
	public Produtos find (Integer id) {
		Optional<Produtos> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Produtos insertNormal (Produtos obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	//ATUALIZAR
	public Produtos update (Produtos obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Produtos> findAll(){
		return rep.findAll();
	}
	
	public Produtos buscar(Integer id) {
		Optional<Produtos> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Produtos insert(Produtos obj) {
		obj.setId(null);
		obj.setNome_produto(obj.getNome_produto());
		obj.setInsumo(insumoService.findAll());
		obj = rep.save(obj);
		
		for (Insumo r : obj.getInsumo()) {
			r.setId(r.getId());
			r.setQuantidade_estoque(r.getQuantidade_estoque()-obj.getQuantidade());
			r.setInsumo(r);
		}
		insumoRepository.saveAll(obj.getInsumo());
		return obj;
	}

	
}
