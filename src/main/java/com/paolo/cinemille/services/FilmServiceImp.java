package com.paolo.cinemille.services;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.paolo.cinemille.dtos.FilmDto;
import com.paolo.cinemille.dtos.FilmFiltersDto;
import com.paolo.cinemille.entities.Film;
import com.paolo.cinemille.repositories.FilmRepository;
import com.paolo.cinemille.specifications.FilmSpecifications;

@Service
public class FilmServiceImp implements FilmService{

	private FilmRepository filmRepository;
	private ModelMapper modelMapper;
	
	public FilmServiceImp(FilmRepository filmRepository, ModelMapper modelMapper) {
		this.filmRepository = filmRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Page<FilmDto> GetFilmsPaginated(Pageable p) {
		Page<Film> source = this.filmRepository.findAll(p);
		return source.map((f)->ConvertToDto(f));
	}
	
	@Override
	public Page<FilmDto> GetFilmsFilteredAndPaginated(FilmFiltersDto filters, Pageable p) {
		
		Specification<Film> spec = FilmSpecifications.AllApplyableFilters(filters);
		
		Page<Film> source = this.filmRepository.findAll(spec,p);
		
		return source.map((f)->ConvertToDto(f));
	}
	
	//Metodi del servizio inutilizzati, li lascio solo per "formalità"
	@Override
	public Page<FilmDto> GetFilmsByTitlePaginated(String title, Pageable p) {
		Page<Film> source =  this.filmRepository.findByTitolo(title, p);
		return source.map((f)->ConvertToDto(f));
	}

	@Override
	public Page<FilmDto> GetFilmsByStartDatePaginated(Date start, Pageable p) {
		Page<Film> source = this.filmRepository.findByDataUscita(start, p);
		return source.map((f)->ConvertToDto(f));
	}

	@Override
	public Page<FilmDto> GetFilmsByEndDatePaginated( Date end, Pageable p) {
		Page<Film> source =  this.filmRepository.findByDataFinePermanenza(end, p);
		return source.map((f)->ConvertToDto(f));
	}
	
	@Override
	public Film GetFilmFromUUID(UUID uuid) {
		return this.filmRepository.findByUuid(uuid);
	}
	
	//Conversione in dto con modelmapper
	private FilmDto ConvertToDto(Film source) {
		return this.modelMapper.map(source, FilmDto.class);
	}
	
}
