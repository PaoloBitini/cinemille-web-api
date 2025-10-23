package com.paolo.cinemille.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.paolo.cinemille.dtos.ProgrammazioniFiltersDto;
import com.paolo.cinemille.entities.Film;
import com.paolo.cinemille.entities.Programmazione;
import com.paolo.cinemille.entities.Sala;

public class ProgrammazioniSpecifications {
	public static Specification<Programmazione> AllApplyableFilters(ProgrammazioniFiltersDto filter) {
		Specification<Programmazione> spec = Specification.unrestricted();
		
		if(StringUtils.hasText(filter.getTitolo())) {
			spec = spec.and(titoloFilter(filter.getTitolo()));
		}
		
		if(StringUtils.hasText(filter.getRegista())) {
			spec = spec.and(registaFilter(filter.getRegista()));
		}
		
		if(StringUtils.hasText(filter.getGenere())) {
			spec = spec.and(genereFilter(filter.getGenere()));
		}
		
		if(StringUtils.hasText(filter.getSala())) {
			spec = spec.and(salaFilter(filter.getSala()));
		}
		
		if(filter.getDaProiezione() != null && filter.getAProiezione() != null && filter.getDaProiezione().compareTo(filter.getAProiezione()) < 0) {
			spec = spec.and(betweenDataProiezioneDates(filter.getDaProiezione(), filter.getAProiezione()));
		}
		
		return spec;
	}

	public static Specification<Programmazione> titoloFilter(String titolo) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<Film>get("film").<String>get("titolo")),
					"%"+titolo.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Programmazione> registaFilter(String regista) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<Film>get("film").<String>get("regista")),
					"%"+regista.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Programmazione> genereFilter(String genere) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<Film>get("film").<String>get("genere")),
					"%"+genere.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Programmazione> salaFilter(String sala) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<Sala>get("sala").<String>get("nome")),
					"%"+sala.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Programmazione> betweenDataProiezioneDates(Date da, Date a) {
		return (root, query, builder) -> {
			return builder.between(root.<Date>get("proiezione"), da, a);
		};
	}	
}
