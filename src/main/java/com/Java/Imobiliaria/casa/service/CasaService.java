package com.Java.Imobiliaria.casa.service;


import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.repository.CasaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class CasaService {




    private final CasaRepository casaRepository;

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }


    public List<CasaModel> listarCasas() {
        return casaRepository.findAll();
    }

    public CasaModel listarCasasPorId(Long id) {
        Optional<CasaModel> casaPorId = casaRepository.findById(id);
        if (casaPorId.isPresent()){
            return casaRepository.getById(id);
        }else {
          return null;
        }
    }

    public String criarCasa() {
        return casaRepository.save(new CasaModel()).toString();
    }

    public List<CasaModel> listarCasasPorValorAluguel(Integer valorAluguelMin,  Integer valorAluguelMax) {
       List<CasaModel> lista = casaRepository.buscaEntreValorAluguel(valorAluguelMin, valorAluguelMax);
        if (lista !=null ) {
            return lista;
        } else {
             System.out.println("Nenhuma casa encontrada nesse intervalo de valor de aluguel!");
            return null;
        }

    }

    public String atualizarCasaPorId(Long id, CasaModel casaAtualizada) {
        if (casaRepository.existsById(id)) {
            casaAtualizada.setId(id);
            casaRepository.save(casaAtualizada);
            return "Casa atualizada com sucesso!";
        } return "Casa não encontrada!";
    }

    public void deletarCasaPorId(Long id) {
        if (casaRepository.existsById(id)) {
            casaRepository.deleteById(id);
        } else {
            System.out.println("Casa não encontrada!");
        }
    }

}
