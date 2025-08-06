package com.Java.Imobiliaria.casa.controller;


import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.service.CasaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    public String CriarCasa(@RequestBody CasaModel casaModel) {
        return casaService.criarCasa();
    }

    @PutMapping("/atualizarCasaPorId/{id}")
    public String atualizarCasaPorId(@RequestBody @PathVariable Long id, CasaModel casaModel) {
       return casaService.atualizarCasaPorId(id, casaModel);
    }

    @GetMapping("/listarCasas")
    public String listarCasas() {
        return casaService.listarCasas().toString();
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
