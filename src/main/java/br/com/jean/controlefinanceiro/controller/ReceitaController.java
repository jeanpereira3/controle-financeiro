package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.exceptions.ValidacaoException;
import br.com.jean.controlefinanceiro.model.dto.AtualizacaoReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.ListagemReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.ReceitaDetalhadaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import br.com.jean.controlefinanceiro.service.receitas.ReceitaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid CadastroReceitaDto dto,
            UriComponentsBuilder uriComponentsBuilder
    ){
        ReceitaDetalhadaDto receitaDetalhadaDto = receitaService.cadastrar(dto);

        URI uri = uriComponentsBuilder.path("/receitas/{id}").buildAndExpand(receitaDetalhadaDto.id()).toUri();
        return ResponseEntity.created(uri).body(receitaDetalhadaDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(
            @PathVariable Long id,
            @RequestBody AtualizacaoReceitaDto dto
            ){
        ReceitaDetalhadaDto receitaDetalhadaDto = receitaService.atualizar(id, dto);
        return ResponseEntity.ok().body(receitaDetalhadaDto);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemReceitaDto>> listar(Pageable pageable, String descricao){
        Page<ListagemReceitaDto> page;
        if (descricao == null){
            page = receitaRepository.findAll(pageable).map(ListagemReceitaDto::new);
        } else {
            page = receitaRepository.findByDescricaoContaining(pageable, descricao).map(ListagemReceitaDto::new);
        }
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id){
        Receita receita = receitaRepository.findById(id).get();
        return ResponseEntity.ok().body(new ReceitaDetalhadaDto(receita));
    }

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity listarPorId(
            Pageable pageable,
            @PathVariable Integer ano,
            @PathVariable Integer mes
    ){
        Page<ListagemReceitaDto> page = receitaRepository
                .findByDataYearAndDataMonth(pageable, ano, mes)
                .map(ListagemReceitaDto::new);

        return ResponseEntity.ok().body(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        receitaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
