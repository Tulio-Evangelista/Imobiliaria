package com.Java.Imobiliaria.configuration;


import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {


    private String palavraSecreta = "palavra-chave";

    public String gerarToken(ClientesModel cliente) {
        Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

        return JWT.create()
                .withSubject(cliente.getEmail())
                .withClaim("nome", cliente.getNome())
                .withClaim("UserId", cliente.getId())
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .withIssuedAt(Instant.now())
                .withIssuer("Imobiliaria API")
                .sign(algorithm);
    }

}
