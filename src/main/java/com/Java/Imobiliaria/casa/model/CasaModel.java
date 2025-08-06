package com.Java.Imobiliaria.casa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_casa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CasaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Quantidade_de_quartos")
    private int quantidadeDeQuartos;

    @Column(name = "Valor_do_aluguel")
    private double valorAluguel;

    @Column(name = "img_casa")
    private String imgCasa;

    public void setId(Long id) {
        this.id = id;
    }
}
