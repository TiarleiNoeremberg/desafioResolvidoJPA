package com.TiarleiNoeremberg.desafioJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TiarleiNoeremberg.desafioJPA.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	public List<Pessoa> findByOrderByNome();
}