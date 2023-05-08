package com.TiarleiNoeremberg.desafioJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TiarleiNoeremberg.desafioJPA.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	public List<Pedido> findByOrderByValorTotal();

}
