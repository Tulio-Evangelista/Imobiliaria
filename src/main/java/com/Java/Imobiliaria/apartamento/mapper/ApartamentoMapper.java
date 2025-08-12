package com.Java.Imobiliaria.apartamento.mapper;

import com.Java.Imobiliaria.apartamento.dto.ApartamentoDTO;
import com.Java.Imobiliaria.apartamento.model.ApartamentoModel;
import org.springframework.stereotype.Component;

@Component
public class ApartamentoMapper {

        ApartamentoDTO apartamentoDTO;

        public ApartamentoModel map(ApartamentoDTO apartamentoDTO) {
            ApartamentoModel apartamentoModel = new ApartamentoModel();
            apartamentoModel.setId(apartamentoDTO.getId());
            apartamentoModel.setEndereco(apartamentoDTO.getEndereco());
            apartamentoModel.setNumeroDeQuartos(apartamentoDTO.getNumeroDeQuartos());
            apartamentoModel.setValorAluguel(apartamentoDTO.getValorAluguel());
            apartamentoModel.setValorCondominio(apartamentoDTO.getValorCondominio());
            apartamentoModel.setImgApartamento(apartamentoDTO.getImgApartamento());
            apartamentoModel.setAceitaPet(apartamentoDTO.getAceitaPet());
            apartamentoModel.setStatusApartamento(apartamentoDTO.getStatusApartamento());
            apartamentoModel.setCliente(apartamentoDTO.getCliente());
            return apartamentoModel;
        }

        public ApartamentoDTO map(ApartamentoModel apartamentoModel) {
            ApartamentoDTO apartamentoDTO = new ApartamentoDTO();
            apartamentoDTO.setId(apartamentoModel.getId());
            apartamentoDTO.setEndereco(apartamentoModel.getEndereco());
            apartamentoDTO.setNumeroDeQuartos(apartamentoModel.getNumeroDeQuartos());
            apartamentoDTO.setValorAluguel(apartamentoModel.getValorAluguel());
            apartamentoDTO.setValorCondominio(apartamentoModel.getValorCondominio());
            apartamentoDTO.setImgApartamento(apartamentoModel.getImgApartamento());
            apartamentoDTO.setAceitaPet(apartamentoModel.getAceitaPet());
            apartamentoDTO.setStatusApartamento(apartamentoModel.getStatusApartamento());
            apartamentoDTO.setCliente(apartamentoModel.getCliente());
            return apartamentoDTO;
        }



}
