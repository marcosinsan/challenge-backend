package br.com.api.financa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.financa.controller.dto.ReceitaDto;
import br.com.api.financa.model.Receita;

@RestController
public class ReceitaController {

	@RequestMapping("/receitas")
	public List<ReceitaDto> lista(){
		
		Receita receita = new Receita("Salário", 300.00);
		
		return ReceitaDto.converte(Arrays.asList(receita,receita));
	}
}
