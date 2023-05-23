package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.exceptions.ValidacaoException;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaConsultaDuplicada implements ReceitaService{
    @Autowired
    private ReceitaRepository receitaRepository;
    @Override
    public void validar(CadastroReceitaDto dto) {

        Receita receita = receitaRepository.findByDescricao(dto.descricao());

        if (receita != null){
            if (receita.getData().equals(dto.data())){
                throw new ValidacaoException("Consulta duplicada");
            }
        }
    }
}
