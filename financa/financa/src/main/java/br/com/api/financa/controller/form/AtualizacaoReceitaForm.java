package br.com.api.financa.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.financa.model.Receita;
import br.com.api.financa.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @DecimalMin(value = "1", message = "Valor tem que ser maior que Zero.")
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
	
	public Receita atualizarFormulario(Long id, ReceitaRepository receitaRepository) {
		Receita r = receitaRepository.getById(id);
		
		r.setDescricao(descricao);
		r.setValor(valor);
		
		return r;		
		
	}
	
}
