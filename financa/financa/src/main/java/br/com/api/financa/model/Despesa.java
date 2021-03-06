package br.com.api.financa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDateTime data = LocalDateTime.now();
	
	public Despesa() {
		
	}
	
	
	public Despesa(String descricao, BigDecimal valor) {
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
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Despesa [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", data=" + data + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, id, valor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(valor, other.valor);
	}
	
	
	
	
}
