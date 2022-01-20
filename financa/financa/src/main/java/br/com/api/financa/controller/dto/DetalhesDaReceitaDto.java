package br.com.api.financa.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.api.financa.model.Receita;

public class DetalhesDaReceitaDto {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDateTime dataCriacao;
	
	public DetalhesDaReceitaDto(Receita receita) {
		
		this.id = receita.getId();
		this.descricao = receita.getDescricao();
		this.valor = receita.getValor();
		this.dataCriacao = receita.getDataCriacao();
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	
}
