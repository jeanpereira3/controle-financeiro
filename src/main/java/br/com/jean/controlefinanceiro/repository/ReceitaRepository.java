package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByDescricao(String descricao);
}
