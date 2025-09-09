package com.Java.Imobiliaria.clientes.service;


import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.Java.Imobiliaria.clientes.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteAuthService {

    private  ClientesRepository clientesRepository;


    public ClientesModel criarClienteAuth(ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }



}
