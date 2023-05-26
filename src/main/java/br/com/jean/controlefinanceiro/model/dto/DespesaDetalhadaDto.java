package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Despesa;

import java.time.LocalDate;

public record DespesaDetalhadaDto(
        Long id,
        String descricao,
        Double valor,
        LocalDate data
) {
    public DespesaDetalhadaDto(Despesa despesa){
        this(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
