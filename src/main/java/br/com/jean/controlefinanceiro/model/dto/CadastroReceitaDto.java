package br.com.jean.controlefinanceiro.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record CadastroReceitaDto(
        @NotBlank
        String descricao,
        @NotNull
        Double valor,
        @NotNull
        LocalDate data
) {
}
