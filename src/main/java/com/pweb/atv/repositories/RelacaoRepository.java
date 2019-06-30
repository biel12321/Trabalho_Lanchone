package com.pweb.atv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pweb.atv.domain.Relacao;

@Repository
public interface RelacaoRepository extends JpaRepository<Relacao, Integer> {

}
