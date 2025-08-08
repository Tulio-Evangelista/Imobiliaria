package com.Java.Imobiliaria.clientes.repository;

import com.Java.Imobiliaria.clientes.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {

    // Métodos adicionais de consulta podem ser definidos aqui, se necessário.
    // Por exemplo, encontrar clientes por nome, email, etc.
    // Exemplo: List<ClientesModel> findByNome(String nome);
}
