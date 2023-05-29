package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
     List<Despesa> findByDescricao(String descricao);
}
