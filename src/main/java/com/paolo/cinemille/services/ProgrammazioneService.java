package com.paolo.cinemille.services;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paolo.cinemille.dtos.ProgrammazioneDto;

public interface ProgrammazioneService {
	
	public Page<ProgrammazioneDto> GetProgrammazioniPaginated(Pageable p);
	
	public Page<ProgrammazioneDto> GetProgrammazioniByFilmTitoloPaginated(String title, Pageable p);
	
	public Page<ProgrammazioneDto> GetProgrammazioniByRangeDatePaginated(Date start, Date end, Pageable p);
	
	public Page<ProgrammazioneDto> GetProgrammazioniBySalaPaginated(String sala, Pageable p);

}
