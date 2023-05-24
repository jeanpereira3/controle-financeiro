package br.com.jean.controlefinanceiro.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompararData {

    public Boolean compararAnoMes(LocalDate data1, LocalDate data2){
        return data1.getYear() == data2.getYear() && data1.getMonth().equals(data2.getMonth());
    }
}
