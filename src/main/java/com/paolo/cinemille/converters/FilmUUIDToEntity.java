package com.paolo.cinemille.converters;

import java.util.UUID;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.paolo.cinemille.entities.Film;
import com.paolo.cinemille.services.FilmService;

@Component
public class FilmUUIDToEntity implements Converter<UUID, Film>{

	private final FilmService filmService;
	
	public FilmUUIDToEntity(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@Override
	public Film convert(MappingContext<UUID, Film> context) {
		
		UUID uuid = context.getSource();
		
		if(uuid != null) {
			return this.filmService.GetFilmFromUUID(uuid);
		}
		return null;
	}

}
