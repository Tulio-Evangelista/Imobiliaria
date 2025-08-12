package com.Java.Imobiliaria.clientes.repository;

import com.Java.Imobiliaria.clientes.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {





}
