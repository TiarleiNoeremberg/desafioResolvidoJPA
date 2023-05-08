package com.TiarleiNoeremberg.desafioJPA.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_item")
public class PedidoItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int quantidade;
    private double valorUnitario;	//copia do valor unitario, preservando o valor na epoca do pedido
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    @JsonIgnore	//barra a serializacao do objeto Pedido
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    public PedidoItem() {
    }

	public PedidoItem(Long id, int quantidade, double valorUnitario, Produto produto, Pedido pedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.produto = produto;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public double getSubTotal() {
		return quantidade * valorUnitario;
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
		PedidoItem other = (PedidoItem) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "PedidoItem [" +
				"id=" + id +
				", produto=" + produto +
				", quantidade=" + quantidade +
				", pedido=" + pedido +
				", valorUnitario=" + valorUnitario +
				"]";
	}
}
