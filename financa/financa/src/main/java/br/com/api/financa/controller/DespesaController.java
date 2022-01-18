package br.com.api.financa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.financa.controller.dto.DespesaDto;
import br.com.api.financa.model.Despesa;

@RestController
public class DespesaController {

	@RequestMapping("/despesas")
	public List<DespesaDto> lista(){
		
		Despesa despesa = new Despesa("Conta de Luz", 178.0);
		
		return DespesaDto.coverte(Arrays.asList(despesa, despesa));
	}
}
