package com.Java.Imobiliaria.clientes.controller;


import com.Java.Imobiliaria.apartamento.enums.StatusApartamento;
import com.Java.Imobiliaria.casa.enums.StatusCasa;
import com.Java.Imobiliaria.clientes.dto.ClientesDTO;
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
    public List<ClientesDTO> listarClientes() {
        return clientesService.listarClientes();
    }

    @PostMapping("/cadastrarClientes")
    public String cadastrarClientes(ClientesDTO clientesDTO) {
        return clientesService.cadastrarClientes(clientesDTO);
    }

    @PutMapping("/editarClientes/{id}")
    public String editarClientes(@PathVariable Long id, ClientesDTO clientesDTO) {
        return clientesService.editarClientesPorId(id, clientesDTO);
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
    public List<ClientesDTO> listarClientesComImovelAlugado(
            @RequestParam StatusApartamento statusApartamento,
            @RequestParam StatusCasa statusCasa) {
        List<ClientesDTO> clientes = clientesService.listarClientesComImovelAlugado(statusApartamento , statusCasa);
        return clientes;
    }

    public String listarClientesComInteresseEmImovel() {
        return "clientes/lista-clientes-interesse-imovel";
    }


}
