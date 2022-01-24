package br.com.api.financa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.financa.controller.form.AtualizacaoDespesaForm;
import br.com.api.financa.controller.form.DespesaForm;
import br.com.api.financa.model.Despesa;
import br.com.api.financa.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRespository;
	
	/**
	 *
	 *@implNote Método que lista todas as decrições das Despesa.
	 * 
	 **/
	public List<Despesa> findAll(String descricao){
		
		if (descricao == null) {
			List<Despesa> despesa = despesaRespository.findAll();
			return despesa;
		} else {
			List<Despesa> despesa = despesaRespository.findByDescricao(descricao);
			
			return despesa;
		}
		
	}
	
	// ============== Método de Cadadastro de Despesa ============= //
	
	@Transactional
	public Despesa cadastro(DespesaForm form) {
		
		Despesa despesa = form.converte();
		
		return despesaRespository.save(despesa);
					
	}
	
	// ============== Método que detalha as despesas ============= //
	
	public Optional<Despesa> detalharDespesaId(Long id) {
		
		 Optional<Despesa> despesa = despesaRespository.findById(id);
		
		return despesa;
	}

	// ============== Método que atualiza as Despesa ============= //
	
	@Transactional
	public Despesa atualizarDespesa(Long id, AtualizacaoDespesaForm form) {
		
		Despesa despesa = form.atualizarForm(id, despesaRespository);
		
		despesa.setDescricao(form.getDescricao());
		despesa.setValor(form.getValor());
		
		return despesa;
	}
	
	// ============== Método que deleta uma Despesa ============= //
	
	@Transactional
	public void deletarDespesa(Long id) {
		despesaRespository.deleteById(id);
	}
}
	
