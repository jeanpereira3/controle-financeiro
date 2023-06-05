package br.com.jean.controlefinanceiro.model.entity;

import br.com.jean.controlefinanceiro.model.dto.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    public Usuario(CadastroUsuarioDto dto) {
        this.nome = dto.nome();
        this.senha = dto.senha();
    }
}
