package com.Java.Imobiliaria.clientes.dto;

import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.clientes.enums.StatusCliente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ClientesDTO {



    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private StatusCliente statusCliente;
    private List<CasaModel> casasAlugadas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public List<CasaModel> getCasasAlugadas() {
        return casasAlugadas;
    }

    public void setCasasAlugadas(List<CasaModel> casasAlugadas) {
        this.casasAlugadas = casasAlugadas;
    }
}
