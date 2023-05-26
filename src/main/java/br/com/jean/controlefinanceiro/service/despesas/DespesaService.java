package br.com.jean.controlefinanceiro.service.despesas;

import br.com.jean.controlefinanceiro.model.dto.CadastroDespesaDto;
import br.com.jean.controlefinanceiro.model.dto.DespesaDetalhadaDto;
import br.com.jean.controlefinanceiro.model.entity.Despesa;
import br.com.jean.controlefinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private List<DespesaValidacaoCadastro> validacaoCadastros;
    public DespesaDetalhadaDto cadastrar(CadastroDespesaDto dto) {

        validacaoCadastros.forEach(v -> v.validar(dto));

        Despesa despesa = new Despesa(dto);
        despesaRepository.save(despesa);
        return new DespesaDetalhadaDto(despesa);
    }
}
