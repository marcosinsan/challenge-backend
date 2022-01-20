package br.com.api.financa.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.api.financa.model.Despesa;

public class DetalhesDaDespesaDto {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDateTime data;
	
	public DetalhesDaDespesaDto(Despesa despesa) {
		this.id = despesa.getId();
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
		this.data = despesa.getData();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	
}
