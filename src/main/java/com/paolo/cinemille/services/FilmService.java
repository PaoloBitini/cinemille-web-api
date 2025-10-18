package com.paolo.cinemille.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paolo.cinemille.dtos.FilmDto;
import com.paolo.cinemille.entities.Film;

public interface FilmService {
	
	public Film GetFilmFromUUID(UUID uuid); 
	
	public Page<FilmDto> GetFilmsPaginated(Pageable p);
	
	public Page<FilmDto> GetFilmsByTitlePaginated(String title, Pageable p);
	
	public Page<FilmDto> GetFilmsByStartDatePaginated(Date start, Pageable p);
	
	public Page<FilmDto> GetFilmsByEndDatePaginated(Date end, Pageable p);

}
