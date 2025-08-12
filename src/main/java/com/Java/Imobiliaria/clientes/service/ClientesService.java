package com.Java.Imobiliaria.clientes.service;


import com.Java.Imobiliaria.apartamento.enums.StatusApartamento;
import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import com.Java.Imobiliaria.apartamento.repository.ApartamentoRepository;
import com.Java.Imobiliaria.casa.enums.StatusCasa;
import com.Java.Imobiliaria.casa.model.CasaModel;
import com.Java.Imobiliaria.casa.repository.CasaRepository;
import com.Java.Imobiliaria.clientes.dto.ClientesDTO;
import com.Java.Imobiliaria.clientes.mapper.ClientesMapper;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import com.Java.Imobiliaria.clientes.repository.ClientesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    CasaRepository casaRepository;

    @Autowired
    ClientesMapper clientesMapper;

    @Autowired
    ApartamentoRepository apartamentoRepository;

    public ClientesService(ClientesRepository clientesRepository, CasaRepository casaRepository, ClientesMapper clientesMapper, ApartamentoRepository apartamentoRepository) {
        this.clientesRepository = clientesRepository;
        this.casaRepository = casaRepository;
        this.clientesMapper = clientesMapper;
        this.apartamentoRepository = apartamentoRepository;
    }

    public List<ClientesDTO> listarClientes() {
        return clientesRepository.findAll().stream()
                .map(clientesMapper::map)
                .toList();
    }

    public String cadastrarClientes(ClientesDTO clientesDTO) {
       ClientesModel criarCliente = clientesMapper.map(clientesDTO);
       criarCliente = clientesRepository.save(criarCliente);
       return clientesMapper.map(clientesDTO).toString() + " cadastrado com sucesso!";
    }

    public String editarClientesPorId(Long id, ClientesDTO clientesDTO) {
        Optional<ClientesModel> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()){
            ClientesModel clientesAtualizado = clientesMapper.map(clientesDTO);
            clientesAtualizado.setId(id);
            clientesRepository.save(clientesAtualizado);
            return clientesMapper.map(clientesAtualizado).toString() + " atualizado com sucesso!";
        }return "Cliente não encontrado!";
    }

    public void excluirClientes(Long id) {
        if (clientesRepository.existsById(id)) {
            clientesRepository.deleteById(id);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public List<ClientesDTO> listarClientesPorId(Long id) {
        return clientesRepository.findAllById(Collections.singleton(id)).stream()
                .map(clientesMapper::map)
                .toList();
    }

        public List<ClientesDTO> listarClientesComImovelAlugado(StatusApartamento statusApartamento, StatusCasa statusCasa) {
        List<CasaModel> casasAlugadas = casaRepository.findByStatusCasa(StatusCasa.ALUGADO);
        List<ApartamentoModel> apartamentosAlugados = apartamentoRepository.findByStatusApartamento(StatusApartamento.ALUGADO);

        Set<Long> idsClientes= new HashSet<>();
        casasAlugadas.forEach(casa -> idsClientes.add(casa.getCliente().getId()));
        apartamentosAlugados.forEach(apartamento -> idsClientes.add(apartamento.getCliente().getId()));
        if (idsClientes.isEmpty()) {
            System.out.println("Nenhum cliente com imóvel alugado encontrado!");
            return Collections.emptyList();
        } return  clientesRepository.findAllById(idsClientes).stream()
                .map(clientesMapper::map)
                .toList();
    }

    public void listarClientesComInteresseEmImovel() {

    }


}
