package br.com.api.financa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.financa.controller.form.DespesaForm;
import br.com.api.financa.model.Despesa;
import br.com.api.financa.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRespository;
	
	public List<Despesa> findAll(String descricao){
		
		if (descricao == null) {
			List<Despesa> despesa = despesaRespository.findAll();
			return despesa;
		} else {
			List<Despesa> despesa = despesaRespository.findByDescricao(descricao);
			
			return despesa;
		}
		
	}
	
	public Despesa cadastro(DespesaForm form) {
		
		Despesa despesa = form.converte();
		
		return despesaRespository.save(despesa);
					
	}
}
	
