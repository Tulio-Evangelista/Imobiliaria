package com.Java.Imobiliaria.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_clientes")
public class ClientesModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, name = "nome")
    private String nome;

    @Column(nullable = true, length = 11, unique = true, name = "cpf")
    private String cpf;

    @Column(nullable = true, length = 20, name = "telefone")
    private String telefone;

    @Column(nullable = true, length = 50, unique = true, name = "email")
    private String email;




}
