package com.Java.Imobiliaria.clientes.model;

import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.clientes.enums.StatusCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status_cliente", nullable = true)
    private StatusCliente statusCliente;

    //clientes podem alugar várias casas
    @OneToMany(mappedBy = "cliente")
    private List<CasaModel> casasAlugadas;






}
