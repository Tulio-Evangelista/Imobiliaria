package com.Java.Imobiliaria.casa.controller;


import com.Java.Imobiliaria.casa.dto.CasaDTO;
import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService casaService;
    private CasaModel casaModel;

    @GetMapping("/testerotacasa")
    public String getCasa() {
        return "Rota para Casas ";
    }

    @PostMapping("/criarCasa")
    public String CriarCasa(@RequestBody CasaDTO casaDTO) {
        return casaService.criarCasa(casaDTO);
    }

    @PutMapping("/atualizarCasaPorId/{id}")
    public CasaDTO atualizarCasaPorId(@RequestBody @PathVariable Long id, CasaDTO casaDTO) {
       return casaService.atualizarCasaPorId(id, casaDTO);
    }

    @GetMapping("/listarCasas")
    public List<CasaDTO> listarCasas() {
        return casaService.listarCasas();
    }

    @GetMapping("/listarCasasPorValorAluguel")
    public List<CasaDTO> listarCasasPorValorAluguel(@RequestParam Integer valorAluguelMin, @RequestParam Integer valorAluguelMax) {
        return casaService.listarCasasPorValorAluguel(valorAluguelMin, valorAluguelMax);
    }

    @GetMapping("/listarCasasPorId/{id}")
    public String listarCasasPorId(@PathVariable Long id) {
        return casaService.listarCasasPorId(id).toString();
    }

    @DeleteMapping("/deletarCasaPorId")
    public void deleteCasaPorId(@PathVariable Long id) {
        casaService.deletarCasaPorId(id);
    }

}
