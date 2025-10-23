package com.paolo.cinemille.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paolo.cinemille.dtos.SalaDto;
import com.paolo.cinemille.entities.Sala;

public interface SalaService {
	
	public Page<SalaDto> GetSalePaginated(Pageable p);
	
	public Sala GetSalaFromUUID(UUID uuid);
	
}
