package com.tiagoalmeida.comidaboa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Cozinheiro;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {	

}
