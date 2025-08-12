package com.Java.Imobiliaria.casa.service;


import com.Java.Imobiliaria.casa.dto.CasaDTO;
import com.Java.Imobiliaria.casa.mapper.CasaMapper;
import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class CasaService {



    @Autowired
    private final CasaRepository casaRepository;

    @Autowired
    CasaMapper casaMapper = new CasaMapper();

    public CasaService(CasaRepository casaRepository, CasaMapper casaMapper) {
        this.casaRepository = casaRepository;
        this.casaMapper = casaMapper;
    }

    public List<CasaDTO> listarCasas() {
        return casaRepository.findAll().stream()
                .map(casaMapper::map)
                .collect(Collectors.toList());
    }

    public CasaDTO listarCasasPorId(Long id) {
        Optional<CasaModel> casa = casaRepository.findById(id);
        if (casa.isPresent()) {
            return casaMapper.map(casa.get());
        } else {
            System.out.println("Casa não encontrada!");
            return null;
        }
    }

    public String criarCasa(CasaDTO casaDTO) {
        CasaModel casa = casaMapper.map(casaDTO);
        casa = casaRepository.save(casa);
        return casaMapper.map(casa).toString() + " criada com sucesso!";
    }

    public List<CasaDTO> listarCasasPorValorAluguel(Integer valorAluguelMin,  Integer valorAluguelMax) {
       List<CasaModel> lista = casaRepository.buscaEntreValorAluguel(valorAluguelMin, valorAluguelMax);
        if (lista !=null ) {
            return lista.stream()
                    .map(casaMapper::map)
                    .collect(Collectors.toList());
        } else {
             System.out.println("Nenhuma casa encontrada nesse intervalo de valor de aluguel!");
            return null;
        }

    }

    public CasaDTO atualizarCasaPorId(Long id, CasaDTO casaDTO) {
        Optional<CasaModel> casa = casaRepository.findById(id);
        if (casa.isPresent()) {
            CasaModel casaAtualizado = casaMapper.map(casaDTO);
            casaAtualizado.setId(id);
            CasaModel casaAtualizada =  casaRepository.save(casaAtualizado);
            return casaMapper.map(casaAtualizada);
        } else {
            return null;
        }

    }

    public void deletarCasaPorId(Long id) {
        if (casaRepository.existsById(id)) {
            casaRepository.deleteById(id);
        } else {
            System.out.println("Casa não encontrada!");
        }
    }

}
