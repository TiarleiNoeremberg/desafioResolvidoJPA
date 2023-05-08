package com.TiarleiNoeremberg.desafioJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TiarleiNoeremberg.desafioJPA.entities.Pessoa;
import com.TiarleiNoeremberg.desafioJPA.repositories.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	@GetMapping(value = "/listar")
	public ResponseEntity <List<Pessoa>> listar() throws Exception {
		List<Pessoa> result = pessoaRepository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/listar/{id}")
	public ResponseEntity<Pessoa> listarPorId(@PathVariable Long id) throws Exception {
		Pessoa result = pessoaRepository.findById(id).get();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/listar/alfabetico")
	public ResponseEntity<List<Pessoa>> listarOrdenadoNome(){
		List<Pessoa> result = pessoaRepository.findByOrderByNome();
		return ResponseEntity.ok(result);
	}
//final
}
