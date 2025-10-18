package com.paolo.cinemille.services;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paolo.cinemille.dtos.ProgrammazioneDto;
import com.paolo.cinemille.entities.Programmazione;
import com.paolo.cinemille.repositories.FilmRepository;
import com.paolo.cinemille.repositories.ProgrammazioneRepository;

@Service
public class ProgrammazioneServiceImp implements ProgrammazioneService{

	private ProgrammazioneRepository programmazioneRepository;
	private ModelMapper modelMapper;
	
	public ProgrammazioneServiceImp(ProgrammazioneRepository programmazioneRepository, ModelMapper modelMapper, FilmRepository filmRepository) {
		this.programmazioneRepository = programmazioneRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniPaginated(Pageable p) {
		Page<Programmazione> source = this.programmazioneRepository.findAll(p);
		return source.map((f)->ConvertToDto(f));
	}

	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniByFilmTitoloPaginated(String title, Pageable p) {
		Page<Programmazione> source = this.programmazioneRepository.findByFilmTitolo(title, p);
		return source.map((f)->ConvertToDto(f));
	}

	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniByRangeDatePaginated(Date start, Date end, Pageable p) {
		Page<Programmazione> source = this.programmazioneRepository.findByRangeDate(start, end, p);
		return source.map((f)->ConvertToDto(f));
	}

	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniBySalaPaginated(String sala, Pageable p) {
		Page<Programmazione> source = this.programmazioneRepository.findBySala(sala, p);
		return source.map((f)->ConvertToDto(f));
	}
	
	private ProgrammazioneDto ConvertToDto(Programmazione source) {
		return this.modelMapper.map(source, ProgrammazioneDto.class);
	}

}
