package br.com.jean.controlefinanceiro.model.entity;

import br.com.jean.controlefinanceiro.model.dto.AtualizacaoReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Receita")
@Table(name = "receitas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    public Receita(CadastroReceitaDto dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
    }

    public Receita atualizar(AtualizacaoReceitaDto dto) {
        if (dto.descricao() != null){
            this.descricao = dto.descricao();
        }
        if (dto.valor() != null){
            this.valor = dto.valor();
        }
        if (dto.data() != null){
            this.data = dto.data();
        }
        return this;
    }
}
