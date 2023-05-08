package com.TiarleiNoeremberg.desafioJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TiarleiNoeremberg.desafioJPA.entities.Pedido;
import com.TiarleiNoeremberg.desafioJPA.repositories.PedidoRepository;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping(value = "/listar")
	public ResponseEntity <List<Pedido>> listar() throws Exception {
		List<Pedido> result = pedidoRepository.findAll();
		return ResponseEntity.ok(result);
	}
			
	@GetMapping(value = "/listar/{idCliente}")
	public ResponseEntity<Pedido> listarByCliente(@PathVariable Long idCliente) throws Exception {
		Pedido result = pedidoRepository.findById(idCliente).get();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/listar/total")
	public ResponseEntity<List<Pedido>> listarOrdenadoPorValorTotal(){
		 List<Pedido> result = pedidoRepository.findByOrderByValorTotal();
		 return ResponseEntity.ok(result);
	}
//final	
}
