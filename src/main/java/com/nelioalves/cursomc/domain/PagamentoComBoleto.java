package com.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;

	// Formatando para apresentar dat padrão
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	// Formatando para apresentar data padrão
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	//private Pagamento pagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedidos, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedidos);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	
}
