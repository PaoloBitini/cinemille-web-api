package com.paolo.cinemille.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paolo.cinemille.dtos.SalaDto;
import com.paolo.cinemille.entities.Sala;
import com.paolo.cinemille.repositories.SalaRepository;

@Service
public class SalaServiceImp implements SalaService{

	private SalaRepository salaRepository;
	private ModelMapper modelMapper;
	
	public SalaServiceImp(SalaRepository salaRepository, ModelMapper modelMapper) {
		this.salaRepository = salaRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Page<SalaDto> GetSalePaginated(Pageable p) {
		Page<Sala> source = this.salaRepository.findAll(p);
		return source.map((f)->ConvertToDto(f));
	}
	
	//Metodi del servizio inutilizzati, li lascio solo per "formalità"
	@Override
	public Sala GetSalaFromUUID(UUID uuid) {
		return this.salaRepository.findByUuid(uuid);
	}
	
	//Conversione in dto con modelmapper
	private SalaDto ConvertToDto(Sala source) {
		return this.modelMapper.map(source, SalaDto.class);
	}

}
