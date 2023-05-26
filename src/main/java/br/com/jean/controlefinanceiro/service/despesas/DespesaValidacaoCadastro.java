package br.com.jean.controlefinanceiro.service.despesas;

import br.com.jean.controlefinanceiro.model.dto.CadastroDespesaDto;

public interface DespesaValidacaoCadastro {
    void validar(CadastroDespesaDto dto);
}
