package com.Java.Imobiliaria.configuration;


import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

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
    public Optional<JWTUserData> validarToken(String token) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            DecodedJWT verify = JWT.require(algorithm)
                    .withIssuer("imobiliaria")
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData
                    .builder()
                    .id(verify.getClaim("id").asLong())
                    .name(verify.getClaim("name").asString())
                    .email(verify.getSubject())
                    .build());


        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }

    }

}
