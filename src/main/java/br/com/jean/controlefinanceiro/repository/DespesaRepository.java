package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    Despesa findByDescricao(String descricao);
}
