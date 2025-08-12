package com.Java.Imobiliaria.clientes.controller;


import com.Java.Imobiliaria.apartamento.enums.StatusApartamento;
import com.Java.Imobiliaria.casa.enums.StatusCasa;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.Java.Imobiliaria.clientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @GetMapping("/listarClientes")
    public String listarClientes() {
        return clientesService.listarClientes().toString();
    }

    @PostMapping("/cadastrarClientes")
    public String cadastrarClientes() {
        return clientesService.cadastrarClientes();
    }

    @PutMapping("/editarClientes/{id}")
    public String editarClientes(@PathVariable Long id, ClientesModel clienteAtualizado) {
        return clientesService.editarClientesPorId(id, clienteAtualizado);
    }

    @DeleteMapping("/excluirClientes/{id}")
    public void excluirClientes(@PathVariable Long id) {
        clientesService.excluirClientes(id);
    }

    @GetMapping("/listarClientesPorId/{id}")
    public String listarClientesPorId(@PathVariable Long id) {
        return clientesService.listarClientesPorId(id).toString();
    }

    @GetMapping("/listarClientesComImovelAlugado")
    public List<ClientesModel> listarClientesComImovelAlugado(
            @RequestParam StatusApartamento statusApartamento,
            @RequestParam StatusCasa statusCasa) {
        List<ClientesModel> clientes = clientesService.listarClientesComImovelAlugado(statusApartamento , statusCasa);
        return clientes;
    }

    public String listarClientesComInteresseEmImovel() {
        return "clientes/lista-clientes-interesse-imovel";
    }


}
