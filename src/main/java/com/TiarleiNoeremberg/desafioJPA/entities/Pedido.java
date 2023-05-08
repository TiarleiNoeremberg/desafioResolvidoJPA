package com.TiarleiNoeremberg.desafioJPA.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "idCliente")
    private Pessoa pessoa;
	
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> itens = new ArrayList<>();
	
	private double valorTotal;
    
    public Pedido() {
    }
    
    public Pedido(Long id, Pessoa pessoa, double valorTotal) {
    	super();
		this.id = id;
		this.pessoa = pessoa;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	//Metodo setItens nao sera implementada a fim de preservar a integridade da lista
	/*
	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}
	*/
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getValorTotal() {
		valorTotal = 0.0;
		for (PedidoItem item : itens ) {
			valorTotal += item.getSubTotal();
		}
		return valorTotal;
	}

	@Override
	public String toString() {
		return "Pedido [" +
				"id=" + id +
				", itens=" + itens +
				", pessoa=" + pessoa +
				", valorTotal=" + valorTotal +
				"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
