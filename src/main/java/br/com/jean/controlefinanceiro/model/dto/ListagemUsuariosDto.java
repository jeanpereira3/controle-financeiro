package br.com.jean.controlefinanceiro.model.dto;

import br.com.jean.controlefinanceiro.model.entity.Usuario;

public record ListagemUsuariosDto(String nome) {
    public ListagemUsuariosDto(Usuario usuario) {
        this(usuario.getNome());
    }
}
