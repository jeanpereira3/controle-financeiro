package br.com.jean.controlefinanceiro.service.receitas;

import br.com.jean.controlefinanceiro.exceptions.ValidacaoException;
import br.com.jean.controlefinanceiro.model.dto.CadastroReceitaDto;
import br.com.jean.controlefinanceiro.model.entity.Receita;
import br.com.jean.controlefinanceiro.repository.ReceitaRepository;
import br.com.jean.controlefinanceiro.utils.CompararData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidaReceitaDuplicadaCadastro implements ReceitaValidacaoCadastro {
    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private CompararData compararData;
    @Override
    public void validar(CadastroReceitaDto dto) {
        List<Receita> receitas = receitaRepository.findByDescricao(dto.descricao());

        receitas.forEach(receita -> {
            if (receita != null){


                Boolean data = compararData.compararAnoMes(receita.getData(), dto.data());

                if (data){
                    throw new ValidacaoException("Ja existe receita com essa descricao para esse mes");
                }

            }
        });



    }
}
