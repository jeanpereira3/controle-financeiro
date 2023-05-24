package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.model.dto.AtualizacaoReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.dto.ReceitaDetalhadaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private List<ReceitaValidacaoCadastro> validacaoCadastro;
    @Autowired
    private List<ReceitaValidacaoAtualizar> validacaoAtializar;

    public ReceitaDetalhadaDto cadastrar(CadastroReceitaDto dto){

        validacaoCadastro.forEach(v -> v.validar(dto));

        Receita receita = new Receita(dto);
        receitaRepository.save(receita);
        return new ReceitaDetalhadaDto(receita);
    }

    public ReceitaDetalhadaDto atualizar(Long id, AtualizacaoReceitaDto dto){

        validacaoAtializar.forEach(v -> v.validar(dto));

        Receita receita = receitaRepository.getReferenceById(id);
        Receita receitaAtualizada = receita.atualizar(dto);
        return new ReceitaDetalhadaDto(receitaAtualizada);
    }
}
