package br.com.jean.controlefinanceiro.controller;

import br.com.jean.controlefinanceiro.model.dto.ResumoDto;
import br.com.jean.controlefinanceiro.service.resumo.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumo")
public class ResumoController {

    @Autowired
    private ResumoService resumoService;
    @GetMapping("/{ano}/{mes}")
    public ResponseEntity resumoMensal(
            @PathVariable Integer ano,
            @PathVariable Integer mes
    ){
        ResumoDto dto = resumoService.obterResumo(ano, mes);
        return ResponseEntity.ok().body(dto);
    }
}
