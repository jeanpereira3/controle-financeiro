package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Receita;

import java.time.LocalDate;

public record ListagemReceitaDto(
        String descricao,
        Double valor,
        LocalDate data
) {
    public ListagemReceitaDto(Receita receita){
        this(receita.getDescricao(), receita.getValor(), receita.getData());
    }
}
