package com.Java.Imobiliaria.clientes.mapper;


import com.Java.Imobiliaria.clientes.dto.request.ClienteRequest;
import com.Java.Imobiliaria.clientes.dto.response.ClienteResponse;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthMapper {

    public static ClientesModel toModel(ClienteRequest request) {
        return ClientesModel
                .builder()
                .email(request.email())
                .password(request.password())
                .build();
    }


    public static ClienteResponse toResponse(ClientesModel clienteResponse ) {
        return ClienteResponse
                .builder()
                .name(clienteResponse.getNome())
                .email(clienteResponse.getEmail())
                .build();
    }

}
