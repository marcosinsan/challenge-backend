package br.com.api.financa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.financa.controller.form.AtualizacaoReceitaForm;
import br.com.api.financa.controller.form.ReceitaForm;
import br.com.api.financa.model.Receita;
import br.com.api.financa.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	public List<Receita> findAll(String descricao){
		
		if(descricao == null) {
			List<Receita> receita = receitaRepository.findAll();
			return receita;
		} 
		
		List<Receita> receita = receitaRepository.findByDescricao(descricao);
		return receita;
	}

	@Transactional
	public Receita cadastra(ReceitaForm form) {
		
		Receita receita = form.converte();
		
		return receitaRepository.save(receita);
	}

	public Receita detalharReceitaId(Long id) {
		Receita receita = receitaRepository.getById(id);
		return receita;
	}
	
	@Transactional
	public Receita atualizarReceita(Long id, AtualizacaoReceitaForm form) {
		
		Receita receita = form.atualizarFormulario(id, receitaRepository);
		
		return receita;
	}

	@Transactional
	public void deletarReceita(Long id) {
		
		receitaRepository.deleteById(id);;
		
	}
	
}
