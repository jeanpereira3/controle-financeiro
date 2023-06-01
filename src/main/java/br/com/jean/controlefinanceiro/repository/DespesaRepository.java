package br.com.jean.controlefinanceiro.repository;

import br.com.jean.controlefinanceiro.model.dto.ResumoPorCategoriaDTO;
import br.com.jean.controlefinanceiro.model.entity.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByDescricao(String descricao);

    Page<Despesa> findByDescricaoContaining(Pageable pageable, String descricao);

    @Query("SELECT d FROM Despesa d WHERE YEAR(d.data) = :ano and MONTH(d.data) = :mes")
    List<Despesa> findByDataYearAndDataMonth(Integer ano, Integer mes);

    @Query("SELECT d FROM Despesa d WHERE YEAR(d.data) = :ano and MONTH(d.data) = :mes")
    Page<Despesa> findByDataYearAndDataMonth(Pageable pageable, Integer ano, Integer mes);

    @Query("SELECT d.categoria, SUM(d.valor) as totalGasto " +
            "FROM Despesa d " +
            "WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes " +
            "GROUP BY d.categoria, MONTH(d.data)")
    List<Object[]> testar(int ano, int mes);


}
