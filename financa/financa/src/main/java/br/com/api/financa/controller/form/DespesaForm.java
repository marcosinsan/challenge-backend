package br.com.api.financa.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.api.financa.model.Despesa;

public class DespesaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @DecimalMin(value = "1.0", message = "Valor não pode ser Zero")
	private BigDecimal valor;
	
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
	public Despesa converte() {
		return new Despesa(descricao, valor);
	}
	
	
}
