package com.Java.Imobiliaria.apartamento.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_apartamento")
public class ApartamentoModel {


    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cidade", nullable = true)
    private String endereco;

    @Column(name = "Numero_de_quartos", nullable = true)
    private Integer numeroDeQuartos;

    @Column(name = "Valor_do_aluguel", nullable = true)
    private String valorAluguel;

    @Column(name = "Valor_do_condominio", nullable = true)
    private String valorCondominio;

    @Column(name = "img_apartamento", nullable = true)
    private String imgApartamento;

    @Column(name = "Aceita_pet", nullable = true)
    private Boolean aceitaPet;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(String valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public void setNumeroDeQuartos(Integer numeroDeQuartos) {
        this.numeroDeQuartos = numeroDeQuartos;
    }

    public String getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(String valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public String getImgApartamento() {
        return imgApartamento;
    }

    public void setImgApartamento(String imgApartamento) {
        this.imgApartamento = imgApartamento;
    }

    public Boolean getAceitaPet() {
        return aceitaPet;
    }

    public void setAceitaPet(Boolean aceitaPet) {
        this.aceitaPet = aceitaPet;
    }
}
