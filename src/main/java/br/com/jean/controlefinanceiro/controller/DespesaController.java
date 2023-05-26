package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.model.dto.CadastroDespesaDto;
import br.com.jean.controlefinanceiro.model.dto.DespesaDetalhadaDto;
import br.com.jean.controlefinanceiro.model.dto.ListagemDespesaDto;
import br.com.jean.controlefinanceiro.repository.DespesaRepository;
import br.com.jean.controlefinanceiro.service.despesas.DespesaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;
    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid CadastroDespesaDto dto,
            UriComponentsBuilder uriComponentsBuilder
            ){
        DespesaDetalhadaDto despesaDetalhadaDto = despesaService.cadastrar(dto);
        URI uri = uriComponentsBuilder.path("despesas/{id}").buildAndExpand(despesaDetalhadaDto.id()).toUri();
        return ResponseEntity.created(uri).body(despesaDetalhadaDto);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemDespesaDto>> listar(Pageable pageable){
        Page<ListagemDespesaDto> page = despesaRepository.findAll(pageable).map(ListagemDespesaDto::new);
        return ResponseEntity.ok().body(page);
    }
}
