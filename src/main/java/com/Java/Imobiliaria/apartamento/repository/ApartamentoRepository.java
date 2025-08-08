package com.Java.Imobiliaria.apartamento.repository;

import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApartamentoRepository extends JpaRepository<ApartamentoModel, Long> {


    List<ApartamentoModel> findByAceitaPet(Boolean aceitaPet);

    @Query("SELECT a FROM ApartamentoModel a WHERE a.valorAluguel BETWEEN :min AND :max")
    List<ApartamentoModel> buscaValorAluguel(@Param("min") Integer valorAluguelMin, @Param("max") Integer valorAluguelMax);

    boolean existsByAceitaPet(Boolean aceitaPet);
}
