package com.Java.Imobiliaria.apartamento.service;


import com.Java.Imobiliaria.apartamento.dto.ApartamentoDTO;
import com.Java.Imobiliaria.apartamento.mapper.ApartamentoMapper;
import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import com.Java.Imobiliaria.apartamento.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartamentoService {

    @Autowired
    public ApartamentoRepository apartamentoRepository;

    @Autowired
    public ApartamentoMapper apartamentoMapper = new ApartamentoMapper();

    public ApartamentoService(ApartamentoRepository apartamentoRepository, ApartamentoMapper apartamentoMapper) {
        this.apartamentoRepository = apartamentoRepository;
        this.apartamentoMapper = apartamentoMapper;
    }

    public String criarApartamento(ApartamentoDTO apartamentoDTO) {
         ApartamentoModel apartamento = apartamentoMapper.map(apartamentoDTO);
        apartamento = apartamentoRepository.save(apartamento);
        return apartamentoMapper.map(apartamento).toString() + " criado com sucesso!";
    }

    public ApartamentoDTO atualizarApartamentoPorId(Long id, ApartamentoDTO apartamentoDTO) {
        Optional<ApartamentoModel> apartamento = apartamentoRepository.findById(id);
        if (apartamento.isPresent()) {
            ApartamentoModel apartamentoAtualizado = apartamentoMapper.map(apartamentoDTO);
            apartamentoAtualizado.setId(id);
            apartamentoAtualizado = apartamentoRepository.save(apartamentoAtualizado);
            return apartamentoMapper.map(apartamentoAtualizado);
        } return null;
    }

    public List<ApartamentoDTO> listarApartamento() {
        List<ApartamentoModel> apartamentos = apartamentoRepository.findAll();
        return apartamentos.stream()
                .map(apartamentoMapper::map)
                .collect(Collectors.toList());
    }


    public List<ApartamentoDTO> listarApartamentosPorValorAluguel(@RequestParam Integer valorAluguelMin,@RequestParam Integer valorAluguelMax) {
        if (apartamentoRepository.buscaValorAluguel(valorAluguelMin, valorAluguelMax) != null){
            return apartamentoRepository.buscaValorAluguel(valorAluguelMin, valorAluguelMax)
                    .stream()
                    .map(apartamentoMapper::map)
                    .collect(Collectors.toList());
        }else{
            System.out.println("Nenhum apartamento encontrado com o valor especificado!");
            return null;
        }
    }


    public void deletarApartamentoPorId(Long id) {
        if (apartamentoRepository.existsById(id)) {
            apartamentoRepository.deleteById(id);
        } else {
            System.out.println("Apartamento não encontrado!");
        }
    }

    public ApartamentoDTO listarApartamentoPorId(Long id) {
        return apartamentoRepository.findById(id)
                .map(apartamentoMapper::map)
                .orElseThrow(() -> new RuntimeException("Apartamento não encontrado!"));
    };

        public List<ApartamentoDTO> listarApartamentosQueAceitamPet(Boolean aceitaPet) {
            return apartamentoRepository.findByAceitaPet(aceitaPet).stream()
                    .map(apartamentoMapper::map)
                    .collect(Collectors.toList());
        }

}


