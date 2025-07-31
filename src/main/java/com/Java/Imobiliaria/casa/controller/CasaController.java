package com.Java.Imobiliaria.casa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CasaController {

    @GetMapping("/casa")
    public String getCasa() {
        return "Rota para Casas ";
    }

    @PostMapping("/criarCasa")
    public String CriarCasa() {
        return "Criar Casa";
    }

    @PutMapping
    public String atualizarCasa() {
        return "Atualizar Casa";
    }

    @GetMapping("/listarCasas")
    public String listarCasas() {
        return "Listar Casas";
    }

}
