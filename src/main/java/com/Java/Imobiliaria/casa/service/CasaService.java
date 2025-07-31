package com.Java.Imobiliaria.casa.service;


import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {




    private final CasaRepository casaRepository;

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }


    public List<CasaModel> listarCasas() {
        return casaRepository.findAll();
    }

    public Optional<CasaModel> listarCasasPorId(Long id) {
        return casaRepository.findById(id);
    }

    public String criarCasa() {
        return casaRepository.save(new CasaModel()).toString();
    }

    public String atualizarCasaPorId(Long id, CasaModel casaModel) {
        if (casaRepository.existsById(id)) {
            casaModel.setId(id);
            casaRepository.save(casaModel);
            return "Casa atualizada com sucesso!";
        } else {
            return "Casa não encontrada!";
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
