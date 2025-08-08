package com.Java.Imobiliaria.casa.model;

import com.Java.Imobiliaria.casa.enums.StatusImovel;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer valorAluguel;

    @Column(name = "img_casa")
    private String imgCasa;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_imovel")
    private StatusImovel statusImovel;


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private ClientesModel cliente;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQuantidadeDeQuartos() {
        return quantidadeDeQuartos;
    }

    public void setQuantidadeDeQuartos(int quantidadeDeQuartos) {
        this.quantidadeDeQuartos = quantidadeDeQuartos;
    }

    public String getImgCasa() {
        return imgCasa;
    }

    public void setImgCasa(String imgCasa) {
        this.imgCasa = imgCasa;
    }

    public Integer getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Integer valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
}
