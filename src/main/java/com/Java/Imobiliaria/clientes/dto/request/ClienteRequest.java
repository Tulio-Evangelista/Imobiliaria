package com.Java.Imobiliaria.clientes.dto.request;


import lombok.Builder;

@Builder
public record ClienteRequest(String name, String email, String password) {




}
