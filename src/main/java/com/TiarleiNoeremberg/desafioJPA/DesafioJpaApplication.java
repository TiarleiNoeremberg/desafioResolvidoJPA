package com.TiarleiNoeremberg.desafioJPA;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TiarleiNoeremberg.desafioJPA.entities.Pedido;
import com.TiarleiNoeremberg.desafioJPA.entities.PedidoItem;
import com.TiarleiNoeremberg.desafioJPA.entities.Pessoa;
import com.TiarleiNoeremberg.desafioJPA.entities.Produto;
import com.TiarleiNoeremberg.desafioJPA.repositories.PedidoItemRepository;
import com.TiarleiNoeremberg.desafioJPA.repositories.PedidoRepository;
import com.TiarleiNoeremberg.desafioJPA.repositories.PessoaRepository;
import com.TiarleiNoeremberg.desafioJPA.repositories.ProdutoRepository;

@SpringBootApplication
public class DesafioJpaApplication implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Pessoa c1 = new Pessoa(null, "51623200059", "Tiarlei Noeremberg"); //Long Id, cpf, nome
		Pessoa c2 = new Pessoa(null, "78599855489", "Janaina Martins");
		pessoaRepository.saveAll(Arrays.asList(c1, c2));
				
		Produto p1 = new Produto(null, "TV", 1000.0);	//Long Id, descricao, valor unitario
		Produto p2 = new Produto(null, "Mouse", 40.0);
		Produto p3 = new Produto(null, "Celular", 900.0);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Pedido o1 = new Pedido(null, c1, 11000.0);	//Long id, pessoa, valorTotal
		Pedido o2 = new Pedido(null, c2, 4620.0);
		pedidoRepository.saveAll(Arrays.asList(o1, o2));
				
		PedidoItem i1 = new PedidoItem(null, 11, 1000.0, p1, o1);	//Long Id, Quantidade, Long, Produto, Pedido
		PedidoItem i2 = new PedidoItem(null, 5, 900.0, p3, o2);
		PedidoItem i3 = new PedidoItem(null, 3, 40.0, p2, o2);
		pedidoItemRepository.saveAll(Arrays.asList(i1, i2, i3));
		
		
		
		
	}

}
