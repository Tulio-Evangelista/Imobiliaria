package com.Java.Imobiliaria.casa.repository;

import com.Java.Imobiliaria.casa.model.CasaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CasaRepository extends JpaRepository<CasaModel, Long> {

    @Query("SELECT a FROM CasaModel a WHERE a.valorAluguel BETWEEN :min AND :max")
    List<CasaModel> buscaEntreValorAluguel(@Param("min") Integer valorAluguelMin, @Param("max") Integer valorAluguelMax);

}
