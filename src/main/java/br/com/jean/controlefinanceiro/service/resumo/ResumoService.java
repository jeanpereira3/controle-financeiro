package br.com.jean.controlefinanceiro.service.resumo;

import br.com.jean.controlefinanceiro.model.dto.ResumoDto;
import br.com.jean.controlefinanceiro.model.dto.ResumoPorCategoriaDTO;
import br.com.jean.controlefinanceiro.model.entity.Despesa;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.DespesaRepository;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumoService {
    private Double totalReceita;
    private Double totalDespesa;
    private Double saldoMes;
    private List<ResumoPorCategoriaDTO> resumos = new ArrayList<>();

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private DespesaRepository despesaRepository;
    public ResumoDto obterResumo(Integer ano, Integer mes) {
        obterReceitaMes(ano, mes);
        obterDespesaMes(ano, mes);
        obterSaldo();
        obterTotalporCategoria(ano, mes);
        return new ResumoDto(totalReceita, totalDespesa, saldoMes, resumos);
    }

    private void obterReceitaMes(Integer ano, Integer mes) {
        totalReceita = 0.0;
        List<Receita> receitas = receitaRepository.findByDataYearAndDataMonth(ano, mes);
        receitas.forEach(r -> {
            totalReceita += r.getValor();
        });
    }

    private void obterDespesaMes(Integer ano, Integer mes) {
        totalDespesa = 0.0;
        List<Despesa> despesas = despesaRepository.findByDataYearAndDataMonth(ano, mes);
        despesas.forEach(d -> {
            totalDespesa += d.getValor();
        });
    }

    private void obterSaldo() {
        saldoMes = 0.0;
        saldoMes = totalReceita - totalDespesa;
    }

    private void obterTotalporCategoria(Integer ano, Integer mes) {

        List<Object[]> resultados = despesaRepository.testar(ano, mes);
        resumos.clear();

        resultados.forEach(r ->{
            ResumoPorCategoriaDTO resumo = new ResumoPorCategoriaDTO(r[0].toString(), (Double) r[1]);
            resumos.add(resumo);
        });
    }
}
