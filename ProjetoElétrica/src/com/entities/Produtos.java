package com.entities;

import java.io.ObjectInputStream.GetField;

public class Produtos {
	
	private Integer id;
	private String produto;
	private Integer quantidade;
	private Double preco;
	private Double precoSaida;
	private Double totalEntrada;
	private Double totalSaida;
	private Double total_estoque;
	
	public Produtos() {
	}
	
	public Produtos(Integer id, String produto, Integer quantidade, Double preco, Double precoSaida, Double totalEntrada,
			Double totalSaida) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.precoSaida = precoSaida;
		this.totalEntrada = totalEntrada;
		this.totalSaida = totalSaida;
		this.total_estoque = total_estoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPrecoSaida() {
		return precoSaida;
	}

	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}

	public Double getTotalEntrada() {
		return totalEntrada;
	}

	public void setTotalEntrada(Double totalEntrada) {
		this.totalEntrada = totalEntrada;
	}

	public Double getTotalSaida() {
		return totalSaida;
	}

	public void setTotalSaida(Double totalSaida) {
		this.totalSaida = totalSaida;
	}

	public Double getTotal_estoque() {
		return total_estoque;
	}

	public void setTotal_estoque(Double total_estoque) {
		this.total_estoque = total_estoque;
	}
	
	
	
	
	
}
