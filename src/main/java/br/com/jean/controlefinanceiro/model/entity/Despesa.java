package br.com.jean.controlefinanceiro.model.entity;

import br.com.jean.controlefinanceiro.model.dto.CadastroDespesaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Despesa")
@Table(name = "despesas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    public Despesa(CadastroDespesaDto dto) {
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.data = dto.data();
    }
}
