package com.Java.Imobiliaria.configuration;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String name, String email) {
}
