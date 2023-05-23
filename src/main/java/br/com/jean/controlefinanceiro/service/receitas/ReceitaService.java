package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;

public interface ReceitaService {
    void validar(CadastroReceitaDto dto);
}
