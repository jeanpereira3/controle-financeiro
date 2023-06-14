package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.model.dto.CadastroUsuarioDto;
import br.com.jean.controlefinanceiro.model.dto.ListagemUsuariosDto;
import br.com.jean.controlefinanceiro.model.dto.TokenJwtDto;
import br.com.jean.controlefinanceiro.model.entity.Usuario;
import br.com.jean.controlefinanceiro.repository.UsuarioRepository;
import br.com.jean.controlefinanceiro.service.usuario.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/cadastrar")
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

    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid CadastroUsuarioDto dto){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(dto.nome(), dto.senha());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(tokenJwt));
    }
}
