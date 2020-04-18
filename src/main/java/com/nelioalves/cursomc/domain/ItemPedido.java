package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore // não será serializado será ignorado pelo spring boot
	@EmbeddedId // por se tratar de uma chave composta
	private ItemPedidoPK id = new ItemPedidoPK();
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	
	public ItemPedido() {
		
	}


	// peculariedade do JPA. Para os programadores que forem utilizar a classe ItemPedido este objeto não faz 
	// o menor sentido e por isso será substitupido por pedido e produto
	//public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {	
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	// incluindo os gets e setters do pedido e do produto
	// para melhorar a semântica da classe ItemPedido
	@JsonIgnore // não pode ser serializado pois tudo que começa com get é serializado
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	// retirado o @JsonIgnore pois os itens do pedido tem que poder serializar (somente no get)  os produtos
	//@JsonIgnore // não pode ser serializado pois tudo que começa com get é serializado
	public Produto getProduto() {
		return id.getProduto();
	}
	
	//fim dos gets e setters do pedido e do produto
	public ItemPedidoPK getId() {
		return id;
	}


	public void setId(ItemPedidoPK id) {
		this.id = id;
	}


	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
