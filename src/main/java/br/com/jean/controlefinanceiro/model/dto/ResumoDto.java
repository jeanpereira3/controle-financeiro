package br.com.jean.controlefinanceiro.model.dto;

import java.util.List;

public record ResumoDto(
        Double totalReceita,
        Double totalDespesa,
        Double saldoMes,
        List<ResumoPorCategoriaDTO> resumoPorCategoria
) {
}
