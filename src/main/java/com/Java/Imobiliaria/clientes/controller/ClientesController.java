package com.Java.Imobiliaria.clientes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller(value = "/clientes")
public class ClientesController {


    public String listarClientes() {
        return "clientes/lista-clientes";
    }

    public String cadastrarClientes() {
        return "clientes/cadastro-clientes";
    }


    public String editarClientes() {
        return "clientes/edicao-clientes";
    }

    public void excluirClientes() {

    }

    public String listarClientesPorId() {
        return "clientes/detalhe-clientes";
    }

    public String listarClientesComImovelAlugado() {
        return "clientes/lista-clientes-imovel-alugado";
    }

    public String listarClientesComInteresseEmImovel() {
        return "clientes/lista-clientes-interesse-imovel";
    }


}
