package com.Java.Imobiliaria.clientes.dto.response;

import lombok.Builder;

@Builder
public record   ClienteResponse (Long id, String name, String email){
}
