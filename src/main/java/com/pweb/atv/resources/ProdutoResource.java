package com.pweb.atv.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pweb.atv.domain.Insumo;
import com.pweb.atv.domain.Produtos;
import com.pweb.atv.dtos.ProdutoDTO;
import com.pweb.atv.services.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Produtos obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Produtos obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	
	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//LISTAR TODOS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "insumo", defaultValue = "") Insumo insumo) {

		//String nomeDecoded = URL.decodeParam(nome);
		//List<Integer> ids = URL.decodeIntList(insumo);
		List<Produtos> list = service.findAll();//(nomeDecoded, ids);
		List<ProdutoDTO> listDto = new ArrayList<ProdutoDTO>();
		for (Produtos i : list) {
			listDto.add(new ProdutoDTO(i));
		}
		return ResponseEntity.ok().body(listDto);

	}
}
