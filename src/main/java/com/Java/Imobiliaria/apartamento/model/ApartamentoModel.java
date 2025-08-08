package com.Java.Imobiliaria.apartamento.model;


import com.Java.Imobiliaria.apartamento.enums.StatusImovel;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer valorAluguel;

    @Column(name = "Valor_do_condominio", nullable = true)
    private Integer valorCondominio;

    @Column(name = "img_apartamento", nullable = true)
    private String imgApartamento;

    @Column(name = "Aceita_pet", nullable = true)
    private Boolean aceitaPet;


    @Enumerated(EnumType.STRING)
    @Column(name = "status_imovel")
    private StatusImovel statusImovel;

    // Apartamento pode ser alugado por um cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private ClientesModel cliente;


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
