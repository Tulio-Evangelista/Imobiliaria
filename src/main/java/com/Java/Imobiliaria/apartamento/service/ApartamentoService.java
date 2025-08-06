package com.Java.Imobiliaria.apartamento.service;


import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import com.Java.Imobiliaria.apartamento.repository.ApartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartamentoService {


    public ApartamentoRepository apartamentoRepository;

    public ApartamentoService(ApartamentoRepository apartamentoRepository) {
        this.apartamentoRepository = apartamentoRepository;
    }

    public String criarApartamento(ApartamentoModel apartamentoModel) {
         apartamentoRepository.save(apartamentoModel);
        return "Apartamento criado com sucesso!";
    }

    public String atualizarApartamentoPorId(Long id, ApartamentoModel apartamentoAtualizado) {
        if (apartamentoRepository.existsById(id)){
            apartamentoAtualizado.setId(id);
            apartamentoRepository.save(apartamentoAtualizado);
            return "Apartamento atualizado com sucesso!";
        }
        return "Apartamento não encontrado!";
    }

    public List<ApartamentoModel> listarApartamento() {
        return apartamentoRepository.findAll();
    }

    public void deletarApartamentoPorId(Long id) {
        if (apartamentoRepository.existsById(id)) {
            apartamentoRepository.deleteById(id);
        } else {
            System.out.println("Apartamento não encontrado!");
        }
    }

    public ApartamentoModel listarApartamentoPorId(Long id) {
        return apartamentoRepository.findById(id).orElse(null);
    }

        public List<ApartamentoModel> listarApartamentosQueAceitamPet(Boolean aceitaPet) {
            return apartamentoRepository.findByAceitaPet(aceitaPet);
        }

}


