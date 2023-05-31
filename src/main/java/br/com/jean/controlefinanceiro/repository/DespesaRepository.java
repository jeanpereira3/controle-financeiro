package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.entity.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.DoubleStream;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
     List<Despesa> findByDescricao(String descricao);

    Page<Despesa> findByDescricaoContaining(Pageable pageable, String descricao);
}
