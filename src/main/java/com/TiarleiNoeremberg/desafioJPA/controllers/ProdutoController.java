package com.TiarleiNoeremberg.desafioJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TiarleiNoeremberg.desafioJPA.entities.Produto;
import com.TiarleiNoeremberg.desafioJPA.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping(value = "/listar")
	public ResponseEntity <List<Produto>> listar() throws Exception {
		List<Produto> result = produtoRepository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/listar/preco")
	public ResponseEntity<List<Produto>> listarOrdenadoPorPreco() throws Exception {
		List<Produto> result = produtoRepository.findByOrderByValorUnitario();
		return ResponseEntity.ok(result);
	}
//final
}
