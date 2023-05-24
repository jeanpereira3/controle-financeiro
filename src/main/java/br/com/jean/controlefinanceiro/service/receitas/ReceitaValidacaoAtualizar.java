package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.model.dto.AtualizacaoReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;

public interface ReceitaValidacaoAtualizar {
    void validar(AtualizacaoReceitaDto dto);
}
