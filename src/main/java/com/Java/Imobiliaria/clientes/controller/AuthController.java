package com.Java.Imobiliaria.clientes.controller;


import com.Java.Imobiliaria.clientes.dto.request.ClienteRequest;
import com.Java.Imobiliaria.clientes.dto.response.ClienteResponse;
import com.Java.Imobiliaria.clientes.mapper.AuthMapper;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.Java.Imobiliaria.clientes.service.ClienteAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth/clientes")
public class AuthController {

    private ClienteAuthService clienteAuthService;

    @PostMapping(value = "/criar")
    public ResponseEntity<ClienteResponse> criarClienteAuth(@RequestBody ClienteRequest clienteRequest) {
        {
            ClientesModel saved = clienteAuthService.criarClienteAuth(AuthMapper.toModel(clienteRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(AuthMapper.toResponse(saved));

        }
    }



}
