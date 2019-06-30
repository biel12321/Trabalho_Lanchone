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
import com.pweb.atv.dtos.InsumoDTO;
import com.pweb.atv.resources.utils.URL;
import com.pweb.atv.services.InsumoService;


@RestController
@RequestMapping(value="/insumo")
public class InsumoResource {
	
	@Autowired
	private InsumoService service;
	
	//BUSCAR POR ID
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Insumo> find(@PathVariable Integer id){
			Insumo obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
		//INSERIR
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void>insert(@RequestBody Insumo obj){
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		//ATUALIZAR
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Insumo obj, @PathVariable Integer id){
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
		public ResponseEntity<List<InsumoDTO>> find(
				@RequestParam(value = "nome", defaultValue = "") String nome,
				@RequestParam(value = "insumo", defaultValue = "") Insumo insumo) {

			//String nomeDecoded = URL.decodeParam(nome);
			//List<Integer> ids = URL.decodeIntList(insumo);
			List<Insumo> list = service.findAll();//(nomeDecoded, ids);
			List<InsumoDTO> listDto = new ArrayList<InsumoDTO>();
			for (Insumo i : list) {
				listDto.add(new InsumoDTO(i));
			}
			return ResponseEntity.ok().body(listDto);

		}
}
