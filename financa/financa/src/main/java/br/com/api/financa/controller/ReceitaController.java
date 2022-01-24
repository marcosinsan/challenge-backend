package br.com.api.financa.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.financa.controller.dto.DetalhesDaReceitaDto;
import br.com.api.financa.controller.dto.ReceitaDto;
import br.com.api.financa.controller.form.AtualizacaoReceitaForm;
import br.com.api.financa.controller.form.ReceitaForm;
import br.com.api.financa.model.Receita;
import br.com.api.financa.service.ReceitaService;


/**
 * @author Marco
 *
 */
@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService ;

	
	@GetMapping
	public List<ReceitaDto> lista(String descricao){
		
		List<Receita> receita = receitaService.findAll(descricao);
		
		return ReceitaDto.converte(receita);
	}
	
	@GetMapping("/{id}")
	public DetalhesDaReceitaDto detalhar(@PathVariable Long id) {
		Receita receita = receitaService.detalharReceitaId(id);
		return new DetalhesDaReceitaDto(receita);
	}
	
	@PostMapping
	public ResponseEntity<ReceitaDto> cadastraReceita(@RequestBody @Valid ReceitaForm form, UriComponentsBuilder uriBuilder) {
		
		Receita receita = receitaService.cadastra(form);
		
		URI uri = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoReceitaForm form){
		Receita receita = receitaService.atualizarReceita(id, form);
		
		return ResponseEntity.ok(new ReceitaDto(receita));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		receitaService.deletarReceita(id);
		return ResponseEntity.ok().build();
	}
}
