package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.ReceitaDetalhadaDto;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import br.com.jean.controlefinanceiro.service.receitas.CadastrarReceita;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private CadastrarReceita cadastrarReceita;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid CadastroReceitaDto dto,
            UriComponentsBuilder uriComponentsBuilder
    ){
        ReceitaDetalhadaDto receitaDetalhadaDto = cadastrarReceita.cadastrar(dto);

        URI uri = uriComponentsBuilder.path("/receitas/{id}").buildAndExpand(receitaDetalhadaDto.id()).toUri();
        return ResponseEntity.created(uri).body(receitaDetalhadaDto);
    }
}
