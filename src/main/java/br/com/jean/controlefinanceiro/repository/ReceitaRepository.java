package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.dto.ListagemReceitaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.DoubleStream;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByDescricao(String descricao);

    Page<Receita> findByDescricaoContaining(Pageable pageable ,String descricao);

    @Query("SELECT r FROM Receita r WHERE YEAR(r.data) = :year AND MONTH(r.data) = :month")
    Page<Receita> findByDataYearAndDataMonth(Pageable pageable, int year, int month);

}
