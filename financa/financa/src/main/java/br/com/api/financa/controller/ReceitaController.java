package br.com.api.financa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.financa.model.Receita;

@RestController
public class ReceitaController {

	@RequestMapping("/receitas")
	public List<Receita> lista(){
		
		Receita receita = new Receita("Dispesa do mês.", 300.00);
		Receita receita2 = new Receita("Conta de Luz", 300.00);
		
		return Arrays.asList(receita,receita2);
	}
}
