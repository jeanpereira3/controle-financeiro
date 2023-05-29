package br.com.jean.controlefinanceiro.service.despesas;

import br.com.jean.controlefinanceiro.exceptions.ValidacaoException;
import br.com.jean.controlefinanceiro.model.dto.AtualizacaoDespesaDto;
import br.com.jean.controlefinanceiro.model.dto.CadastroDespesaDto;
import br.com.jean.controlefinanceiro.model.entity.Despesa;
import br.com.jean.controlefinanceiro.repository.DespesaRepository;
import br.com.jean.controlefinanceiro.utils.CompararData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidaDespesaDuplicadaAtualizar implements DespesaValidacaoAtualizar{
    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private CompararData compararData;
    @Override
    public void validar(AtualizacaoDespesaDto dto) {

        List<Despesa> despesas = despesaRepository.findByDescricao(dto.descricao());
        despesas.forEach(despesa -> {
            if (despesa != null){
                Boolean data = compararData.compararAnoMes(despesa.getData(), dto.data());

                if (data){
                    throw new ValidacaoException("Ja existe receita com essa descricao para esse mes");
                }
            }
        });

    }

}
