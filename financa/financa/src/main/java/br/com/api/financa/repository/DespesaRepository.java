package br.com.api.financa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.financa.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	List<Despesa> findByDescricao(String descricao);
	
}
