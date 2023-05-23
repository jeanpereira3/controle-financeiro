package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Receita;

import java.time.LocalDate;

public record ReceitaDetalhadaDto(
        Long id,
        String descricao,
        Double valor,
        LocalDate data
        ) {
    public ReceitaDetalhadaDto(Receita receita) {
        this(receita.getId(), receita.getDescricao(), receita.getValor(), receita.getData());
    }
}
