package com.esprit.examen.converter;

import com.esprit.examen.dto.ReglementDTO;
import com.esprit.examen.entities.Reglement;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReglementConverter {
	
	public ReglementDTO convertEntityToDto(Reglement reglement) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reglement, ReglementDTO.class);

    }

    public Reglement convertDtoToEntity(ReglementDTO reglementdto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reglementdto, Reglement.class);
    }
}
