package com.Java.Imobiliaria.clientes.model;

import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.clientes.enums.StatusCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "tb_clientes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = true, length = 11, unique = true)
    private String cpf;

    @Column(nullable = true, length = 20)
    private String telefone;

    @Column(nullable = true, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_cliente")
    private StatusCliente statusCliente;

    // Clientes podem alugar várias casas
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<CasaModel> casasAlugadas;
}
