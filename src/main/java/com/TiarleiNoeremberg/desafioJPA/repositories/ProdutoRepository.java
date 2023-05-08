package com.TiarleiNoeremberg.desafioJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TiarleiNoeremberg.desafioJPA.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findByOrderByValorUnitario();
}
