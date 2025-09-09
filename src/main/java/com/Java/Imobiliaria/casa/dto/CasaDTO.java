package com.Java.Imobiliaria.casa.dto;

import com.Java.Imobiliaria.casa.enums.StatusCasa;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class CasaDTO {

    private Long id;
    private String cidade;
    private int quantidadeDeQuartos;
    private Integer valorAluguel;
    private String imgCasa;
    private StatusCasa statusCasa;
    private ClientesModel cliente;

    public StatusCasa getStatusCasa() {
        return statusCasa;
    }

    public void setStatusCasa(StatusCasa statusCasa) {
        this.statusCasa = statusCasa;
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
