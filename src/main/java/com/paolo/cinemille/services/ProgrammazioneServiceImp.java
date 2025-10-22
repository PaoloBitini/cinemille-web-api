package com.paolo.cinemille.services;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.paolo.cinemille.dtos.ProgrammazioneDto;
import com.paolo.cinemille.dtos.ProgrammazioniFiltersDto;
import com.paolo.cinemille.entities.Programmazione;
import com.paolo.cinemille.repositories.FilmRepository;
import com.paolo.cinemille.repositories.ProgrammazioneRepository;
import com.paolo.cinemille.specifications.ProgrammazioniSpecifications;

@Service
public class ProgrammazioneServiceImp implements ProgrammazioneService{

	private ProgrammazioneRepository programmazioneRepository;
	private ModelMapper modelMapper;
	
	public ProgrammazioneServiceImp(ProgrammazioneRepository programmazioneRepository, ModelMapper modelMapper, FilmRepository filmRepository) {
		this.programmazioneRepository = programmazioneRepository;
		this.modelMapper = modelMapper;
		
		/*
		 * è stato aggiunto un mappig tra Programmazione -> ProgrammazioneDto 
		 * data la differenza dei struttura 
		 */
		
		this.modelMapper.addMappings(new PropertyMap<Programmazione, ProgrammazioneDto>() {

			@Override
			protected void configure() {
				map().setGenere(source.getFilm().getGenere());
				map().setTitolo(source.getFilm().getTitolo());
				map().setProiezione(source.getProiezione());
				map().setRegista(source.getFilm().getRegista());
				map().setSala(source.getSala().getNome());
				map().setUuid(source.getUuid());
				map().setUuidFilm(source.getFilm().getUuid());
				map().setUuidSala(source.getSala().getUuid());
			}
		});
	}

	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniPaginated(Pageable p) {
		Page<Programmazione> source = this.programmazioneRepository.findAll(p);
		return source.map((f)->ConvertToDto(f));
	}
	
	@Override
	public Page<ProgrammazioneDto> GetProgrammazioniFilteredAndPaginated( ProgrammazioniFiltersDto filters, Pageable p) {
		
		Specification<Programmazione> spec = ProgrammazioniSpecifications.AllApplyableFilters(filters);
		
		Page<Programmazione> source = this.programmazioneRepository.findAll(spec, p);
		return source.map((f)->ConvertToDto(f));
	}

	//Metodi del servizio inutilizzati, li lascio solo per "formalità"
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
	
	//Conversione in dto con modelmapper
	private ProgrammazioneDto ConvertToDto(Programmazione source) {
		return this.modelMapper.map(source, ProgrammazioneDto.class);
	}
}
