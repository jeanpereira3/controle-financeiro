package br.com.jean.controlefinanceiro.model.entity;

import br.com.jean.controlefinanceiro.model.dto.AtualizacaoDespesaDto;
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
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Despesa(CadastroDespesaDto dto) {
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.data = dto.data();
        if (dto.categoria() == null){
            this.categoria = Categoria.OUTRAS;
        } else {
            this.categoria = dto.categoria();
        }
    }

    public Despesa atualizar(AtualizacaoDespesaDto dto) {
        if (dto.descricao() != null){
            this.descricao = dto.descricao();
        }
        if (dto.data() != null){
            this.valor = dto.valor();
        }
        if (dto.data() != null){
            this.data = dto.data();
        }

        return this;
    }
}
