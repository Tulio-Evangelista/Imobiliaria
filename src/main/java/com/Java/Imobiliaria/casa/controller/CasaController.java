package com.Java.Imobiliaria.casa.controller;


import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.service.CasaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private CasaService casaService;
    private CasaModel casaModel;

    @GetMapping("/testerotacasa")
    public String getCasa() {
        return "Rota para Casas ";
    }

    @PostMapping("/criarCasa")
    public String CriarCasa() {
       return casaService.criarCasa();
    }

    @PutMapping("/atualizarCasaPorId/{id}")
    public String atualizarCasaPorId(Long id, CasaModel casaModel) {
        if (casaModel.getId() != null) {
            return casaService.atualizarCasaPorId(id, casaModel);
        } else {
            return "ID da casa é inválido.";
        }
    }

    @GetMapping("/listarCasas")
    public String listarCasas() {
        return casaService.listarCasas().toString();
    }

    @GetMapping("/listarCasasPorId/{id}")
    public String listarCasasPorId(Long id) {
        return casaService.listarCasasPorId(id).toString();
    }

    @DeleteMapping("/deletarCasaPorId")
    public void deleteCasaPorId(Long id) {
        casaService.deletarCasaPorId(id);
    }

}
