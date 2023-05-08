package com.TiarleiNoeremberg.desafioJPA.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String cpf;
    private String nome;
    
    /*
    @OneToMany
    //@ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;	//Associando entidade Pedido na classe Pessoa
    */
    
    public Pessoa() {
    }
    
    public Pessoa(Long id, String cpf, String nome /*, Pedido pedido*/) {
    	super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		//this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	*/

	@Override
	public String toString() {
		return "Pessoa ["+
				"id=" + id + 
				", cpf=" + cpf + 
				", nome=" + nome + 
				//", pedido=" + pedido +
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
		Pessoa other = (Pessoa) obj;
		return id == other.id;
	}
}
