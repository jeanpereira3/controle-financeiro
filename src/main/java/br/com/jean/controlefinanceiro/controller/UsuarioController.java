package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.model.dto.CadastroUsuarioDto;
import br.com.jean.controlefinanceiro.model.dto.ListagemUsuariosDto;
import br.com.jean.controlefinanceiro.model.entity.Usuario;
import br.com.jean.controlefinanceiro.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(
            @RequestBody @Valid CadastroUsuarioDto dto,
            UriComponentsBuilder uriComponentsBuilder
    ){
        Usuario usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListagemUsuariosDto(usuario));
    }
}
