package com.Java.Imobiliaria.clientes.service;


import com.Java.Imobiliaria.apartamento.enums.StatusApartamento;
import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import com.Java.Imobiliaria.apartamento.repository.ApartamentoRepository;
import com.Java.Imobiliaria.casa.enums.StatusCasa;
import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.repository.CasaRepository;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.Java.Imobiliaria.clientes.repository.ClientesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    CasaRepository casaRepository;

    @Autowired
    ApartamentoRepository apartamentoRepository;

    public List<ClientesModel> listarClientes() {
        return clientesRepository.findAll();
    }

    public String cadastrarClientes() {
        return clientesRepository.save(new ClientesModel()).toString();
    }

    public String editarClientesPorId(Long id, ClientesModel clienteAtualizado) {
        if (clientesRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            ClientesModel clienteSalvo =  clientesRepository.save(clienteAtualizado);
            return "Cliente atualizado: " + clienteSalvo.getNome();
        } else {
            throw new EntityNotFoundException("Cliente com id " + id + " não encontrado.");
        }

    }

    public void excluirClientes(Long id) {
        if (clientesRepository.existsById(id)) {
            clientesRepository.deleteById(id);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public List<ClientesModel> listarClientesPorId(Long id) {
        return clientesRepository.findAllById(Collections.singleton(id));
    }

        public List<ClientesModel> listarClientesComImovelAlugado(StatusApartamento statusApartamento, StatusCasa statusCasa) {
        List<CasaModel> casasAlugadas = casaRepository.findByStatusCasa(StatusCasa.ALUGADO);
        List<ApartamentoModel> apartamentosAlugados = apartamentoRepository.findByStatusApartamento(StatusApartamento.ALUGADO);

        Set<Long> idsClientes= new HashSet<>();
        casasAlugadas.forEach(casa -> idsClientes.add(casa.getCliente().getId()));
        apartamentosAlugados.forEach(apartamento -> idsClientes.add(apartamento.getCliente().getId()));
        if (idsClientes.isEmpty()) {
            System.out.println("Nenhum cliente com imóvel alugado encontrado!");
            return Collections.emptyList();
        } return  clientesRepository.findAllById(idsClientes);
    }

    public void listarClientesComInteresseEmImovel() {

    }


}
