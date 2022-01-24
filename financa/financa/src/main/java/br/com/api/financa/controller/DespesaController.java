package br.com.api.financa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import br.com.api.financa.controller.dto.DespesaDto;
import br.com.api.financa.controller.dto.DetalhesDaDespesaDto;
import br.com.api.financa.controller.form.AtualizacaoDespesaForm;
import br.com.api.financa.controller.form.DespesaForm;
import br.com.api.financa.model.Despesa;
import br.com.api.financa.service.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;

	@GetMapping
	public List<DespesaDto> lista(String descricao) {

		List<Despesa> despesas = despesaService.findAll(descricao);
		return DespesaDto.coverte(despesas);

	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaDespesaDto> detalhar(@PathVariable Long id) {
		Optional<Despesa> despesa = despesaService.detalharDespesaId(id);
		if(despesa.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaDespesaDto(despesa.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<DespesaDto> cadastraDespesa(@RequestBody @Valid DespesaForm form,
			UriComponentsBuilder uriBuilder) {

		Despesa despesa = despesaService.cadastro(form);

		URI uri = uriBuilder.path("/despesa/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DespesaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoDespesaForm form){
		
		Despesa despesa = despesaService.atualizarDespesa(id, form);
		
		return ResponseEntity.ok(new DespesaDto(despesa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		despesaService.deletarDespesa(id);
		return ResponseEntity.ok().build();
	}
}
