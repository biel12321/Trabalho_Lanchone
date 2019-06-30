package com.pweb.atv.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.atv.domain.Insumo;
import com.pweb.atv.domain.Produtos;
import com.pweb.atv.repositories.InsumoRepository;
import com.pweb.atv.repositories.ProdutoRepository;


@Service
public class DdService {

	@Autowired
	private InsumoRepository repIns;
	
	@Autowired
	private ProdutoRepository repPro;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		ArrayList<Insumo> p = new ArrayList<Insumo>();
		Insumo i1 = new Insumo("limao", 2);
		Insumo i2 = new Insumo("peixe", 5);
		p.add(i1);
		p.add(i2);
		repIns.saveAll(Arrays.asList(i1, i2));
		
		Produtos p1 = new Produtos("Peixe Frito", p);
		repPro.saveAll(Arrays.asList(p1));
		
		
	}

}
