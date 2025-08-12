package com.Java.Imobiliaria.apartamento.dto;

import com.Java.Imobiliaria.apartamento.enums.StatusApartamento;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDTO {

    private Long id;
    private String endereco;
    private Integer numeroDeQuartos;
    private Integer valorAluguel;
    private Integer valorCondominio;
    private String imgApartamento;
    private Boolean aceitaPet;
    private StatusApartamento statusApartamento;
    private ClientesModel cliente;


    public StatusApartamento getStatusApartamento() {
        return statusApartamento;
    }

    public void setStatusApartamento(StatusApartamento statusApartamento) {
        this.statusApartamento = statusApartamento;
    }

    public ClientesModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModel cliente) {
        this.cliente = cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Integer valorAluguel) {
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

    public Integer getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(Integer valorCondominio) {
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
