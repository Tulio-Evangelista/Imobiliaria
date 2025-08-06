package com.Java.Imobiliaria.apartamento.repository;

import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartamentoRepository extends JpaRepository<ApartamentoModel, Long> {


    List<ApartamentoModel> findByAceitaPet(Boolean aceitaPet);

    boolean existsByAceitaPet(Boolean aceitaPet);
}
