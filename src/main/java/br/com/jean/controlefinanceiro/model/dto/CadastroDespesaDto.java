package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroDespesaDto(
        @NotBlank
        String descricao,
        @NotNull
        Double valor,
        @NotNull
        LocalDate data,
        Categoria categoria
) {
}
