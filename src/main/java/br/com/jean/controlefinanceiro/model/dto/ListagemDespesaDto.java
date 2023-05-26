package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Despesa;

import java.time.LocalDate;

public record ListagemDespesaDto(
        String descricao,
        Double valor,
        LocalDate data
) {
    public ListagemDespesaDto(Despesa despesa){
        this(despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
