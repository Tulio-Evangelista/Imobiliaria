package com.Java.Imobiliaria.apartamento.controller;

import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import com.Java.Imobiliaria.apartamento.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

    @Autowired
    ApartamentoService apartamentoService;


    @PostMapping("/criarApartamento")
    public String criarApartamento(@RequestBody ApartamentoModel apartamentoModel) {
        return apartamentoService.criarApartamento(apartamentoModel);
    }

    @PutMapping("/atualizarApartamentoPorId/{id}")
    public String atualizarApartamentoPorId(@RequestBody @PathVariable Long id) {
        return apartamentoService.atualizarApartamentoPorId(id, new ApartamentoModel());
    }

    @GetMapping("/listarApartamentos")
    public List<ApartamentoModel> listarApartamentos() {
        return apartamentoService.listarApartamento();
    }

    @GetMapping("/listarApartamentosPorId/{id}")
    public ApartamentoModel listarApartamentosPorId(@PathVariable Long id) {
        return apartamentoService.listarApartamentoPorId(id);
    }

    @GetMapping("/listarApartamentosQueAceitamPet/{aceitaPet}")
    public List<ApartamentoModel> listarApartamentosQueAceitamPet(@PathVariable Boolean aceitaPet) {
        return apartamentoService.listarApartamentosQueAceitamPet(aceitaPet);
    }


    @DeleteMapping
    public void deleteApartamentoPorId(Long id) {
        apartamentoService.deletarApartamentoPorId(id);
    }
}
