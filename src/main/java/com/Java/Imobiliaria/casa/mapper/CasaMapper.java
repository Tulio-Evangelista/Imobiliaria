package com.Java.Imobiliaria.casa.mapper;

import com.Java.Imobiliaria.casa.dto.CasaDTO;
import com.Java.Imobiliaria.casa.model.CasaModel;
import org.springframework.stereotype.Component;

@Component
public class CasaMapper {


    public CasaModel map(CasaDTO casaDTO) {
        CasaModel casaModel = new CasaModel();
        casaModel.setId(casaDTO.getId());
        casaModel.setCidade(casaDTO.getCidade());
        casaModel.setQuantidadeDeQuartos(casaDTO.getQuantidadeDeQuartos());
        casaModel.setValorAluguel(casaDTO.getValorAluguel());
        casaModel.setImgCasa(casaDTO.getImgCasa());
        casaModel.setStatusCasa(casaDTO.getStatusCasa());
        casaModel.setCliente(casaDTO.getCliente());
        return casaModel;
    }

    public CasaDTO map(CasaModel casaModel) {
        CasaDTO casaDTO = new CasaDTO();
        casaDTO.setId(casaModel.getId());
        casaDTO.setCidade(casaModel.getCidade());
        casaDTO.setQuantidadeDeQuartos(casaModel.getQuantidadeDeQuartos());
        casaDTO.setValorAluguel(casaModel.getValorAluguel());
        casaDTO.setImgCasa(casaModel.getImgCasa());
        casaDTO.setStatusCasa(casaModel.getStatusCasa());
        casaDTO.setCliente(casaModel.getCliente());
        return casaDTO;
    }

}
