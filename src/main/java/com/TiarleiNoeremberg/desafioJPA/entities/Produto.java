package com.TiarleiNoeremberg.desafioJPA.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	//Alteracao de variavel 'int registro' para 'long id', conforme schema.sql original
    private String descricao;
    private double valorUnitario;

    public Produto() {
    }
    
    public Produto(Long id, String descricao, double valorUnitario) {
    	super();
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
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
		Produto other = (Produto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Produto ["+
				"id=" + id +
				", descricao=" + descricao + '\'' +
				", valorUnitario=" + valorUnitario +
				"]";
	}
}
