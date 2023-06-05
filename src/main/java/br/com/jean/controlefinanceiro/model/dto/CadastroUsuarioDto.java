package br.com.jean.controlefinanceiro.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDto(
        @NotBlank
        String nome,
        @NotBlank
        String senha
) {
}
