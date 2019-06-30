package com.pweb.atv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pweb.atv.domain.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer>{
	
}
