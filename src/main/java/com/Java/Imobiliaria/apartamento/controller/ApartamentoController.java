package com.Java.Imobiliaria.apartamento.controller;

import com.Java.Imobiliaria.apartamento.dto.ApartamentoDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

    @Autowired
    ApartamentoService apartamentoService;


    @PostMapping("/criarApartamento")
        public String criarApartamento(@RequestBody ApartamentoDTO apartamentoDTO) {
        return apartamentoService.criarApartamento(apartamentoDTO);
    }

    @PutMapping("/atualizarApartamentoPorId/{id}")
    public ApartamentoDTO atualizarApartamentoPorId(@RequestBody @PathVariable Long id) {
        return apartamentoService.atualizarApartamentoPorId(id, new ApartamentoDTO());
    }

    @GetMapping("/listarApartamentos")
    public List<ApartamentoDTO> listarApartamentos() {
        return apartamentoService.listarApartamento();
    }

    @GetMapping("/listarApartamentosPorId/{id}")
    public ApartamentoDTO listarApartamentosPorId(@PathVariable Long id) {
        return apartamentoService.listarApartamentoPorId(id);
    }

    @GetMapping("/listarApartamentosQueAceitamPet/{aceitaPet}")
    public List<ApartamentoDTO> listarApartamentosQueAceitamPet(@PathVariable Boolean aceitaPet) {
        return apartamentoService.listarApartamentosQueAceitamPet(aceitaPet);
    }

    @GetMapping("/listarApartamentosPorValorAluguel")
    public List<ApartamentoDTO> listarApartamentosPorValorAluguel(@RequestParam  Integer valorAluguelMin, @RequestParam  Integer valorAluguelMax) {
        return apartamentoService.listarApartamentosPorValorAluguel(valorAluguelMin, valorAluguelMax);
    }

    @DeleteMapping
    public void deleteApartamentoPorId(Long id) {
        apartamentoService.deletarApartamentoPorId(id);
    }
}
