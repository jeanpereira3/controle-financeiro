package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.ReceitaDetalhadaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarReceita {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private List<ReceitaService> receitaServices;

    public ReceitaDetalhadaDto cadastrar(CadastroReceitaDto dto){

        receitaServices.forEach(v -> v.validar(dto));

        Receita receita = new Receita(dto);
        receitaRepository.save(receita);
        return new ReceitaDetalhadaDto(receita);
    }
}
