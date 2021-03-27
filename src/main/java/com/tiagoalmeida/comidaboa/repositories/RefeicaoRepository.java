package com.tiagoalmeida.comidaboa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoalmeida.comidaboa.domain.Refeicao;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer> {	

}
