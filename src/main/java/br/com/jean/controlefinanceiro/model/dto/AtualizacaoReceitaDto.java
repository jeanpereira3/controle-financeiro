package br.com.jean.controlefinanceiro.model.dto;

import java.time.LocalDate;

public record AtualizacaoReceitaDto(String descricao, Double valor, LocalDate data) {
}
