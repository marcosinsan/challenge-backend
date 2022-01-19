package br.com.api.financa.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.financa.controller.dto.ReceitaDto;
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
	
	@PostMapping
	public ResponseEntity<ReceitaDto> cadastraReceita(@RequestBody @Valid ReceitaForm form, UriComponentsBuilder uriBuilder) {
		
		Receita receita = receitaService.cadastra(form);
		
		URI uri = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}
}
