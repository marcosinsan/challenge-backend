package br.com.api.financa.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Receita {
	
	private Long id;
	private String descricao;
	private Double valor;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Receita(String descricao, Double valor) {
		this.descricao = descricao;
		this.valor = valor;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Override
	public String toString() {
		return "Receita [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", data=" + dataCriacao + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, descricao, id, valor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(valor, other.valor);
	}
	
}
