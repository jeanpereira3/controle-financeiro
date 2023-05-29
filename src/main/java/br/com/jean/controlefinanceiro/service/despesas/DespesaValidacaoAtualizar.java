package br.com.jean.controlefinanceiro.service.despesas;

import br.com.jean.controlefinanceiro.model.dto.AtualizacaoDespesaDto;

public interface DespesaValidacaoAtualizar {
    void validar(AtualizacaoDespesaDto dto);
}
