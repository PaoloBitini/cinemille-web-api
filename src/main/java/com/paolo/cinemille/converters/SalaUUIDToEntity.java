package com.paolo.cinemille.converters;

import java.util.UUID;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.paolo.cinemille.entities.Sala;
import com.paolo.cinemille.services.SalaService;

public class SalaUUIDToEntity implements Converter<UUID, Sala>{
	private final SalaService salaService;
	
	public SalaUUIDToEntity(SalaService salaService) {
		this.salaService = salaService;
	}
	
	@Override
	public Sala convert(MappingContext<UUID, Sala> context) {
		
		UUID uuid = context.getSource();
		
		if(uuid != null) {
			return this.salaService.GetSalaFromUUID(uuid);
		}
		return null;
	}
}
