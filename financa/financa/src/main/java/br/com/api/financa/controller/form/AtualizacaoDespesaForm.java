package br.com.api.financa.controller.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.api.financa.model.Despesa;
import br.com.api.financa.repository.DespesaRepository;

public class AtualizacaoDespesaForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @DecimalMin(value = "1.0", message = "Valor deve ser maior que 1.0.")
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
	
	public Despesa atualizarForm(Long id, DespesaRepository despesaRepository ) {
		
		Optional<Despesa> d = despesaRepository.findById(id);
				
		return d.get();
	}
	
	
}
