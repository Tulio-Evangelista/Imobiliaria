package com.Java.Imobiliaria.clientes.mapper;


import com.Java.Imobiliaria.clientes.dto.ClientesDTO;
import com.Java.Imobiliaria.clientes.model.ClientesModel;
import org.springframework.stereotype.Component;

@Component
public class ClientesMapper {


    public ClientesDTO map(ClientesModel clientesModel) {
        ClientesDTO clientesDTO = new ClientesDTO();
        clientesDTO.setId(clientesModel.getId());
        clientesDTO.setNome(clientesModel.getNome());
        clientesDTO.setCpf(clientesModel.getCpf());
        clientesDTO.setTelefone(clientesModel.getTelefone());
        clientesDTO.setEmail(clientesModel.getEmail());
        clientesDTO.setStatusCliente(clientesModel.getStatusCliente());
        clientesDTO.setCasasAlugadas(clientesModel.getCasasAlugadas());
        return clientesDTO;
    }

    public ClientesModel map(ClientesDTO clientesDTO) {
        ClientesModel clientesModel = new ClientesModel();
        clientesModel.setId(clientesDTO.getId());
        clientesModel.setNome(clientesDTO.getNome());
        clientesModel.setCpf(clientesDTO.getCpf());
        clientesModel.setTelefone(clientesDTO.getTelefone());
        clientesModel.setEmail(clientesDTO.getEmail());
        clientesModel.setStatusCliente(clientesDTO.getStatusCliente());
        clientesModel.setCasasAlugadas(clientesDTO.getCasasAlugadas());
        return clientesModel;
    }
}
