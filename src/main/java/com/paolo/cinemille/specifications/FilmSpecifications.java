package com.paolo.cinemille.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.paolo.cinemille.dtos.FilmFiltersDto;
import com.paolo.cinemille.entities.Film;

public class FilmSpecifications {
	
	public static Specification<Film> AllApplyableFilters(FilmFiltersDto filter) {
		
		Specification<Film> spec = Specification.unrestricted();
		
		if(StringUtils.hasText(filter.getTitolo())) {
			spec = spec.and(titoloFilter(filter.getTitolo()));
		}
		
		if(StringUtils.hasText(filter.getRegista())) {
			spec = spec.and(registaFilter(filter.getRegista()));
		}
		
		if(StringUtils.hasText(filter.getGenere())) {
			spec = spec.and(genereFilter(filter.getGenere()));
		}
		
		if(filter.getDaDataUscita() != null && filter.getADataUscita() != null && filter.getDaDataUscita().compareTo(filter.getADataUscita()) < 0) {
			spec = spec.and(betweenDataUscitaDates(filter.getDaDataUscita(), filter.getADataUscita()));
		}
		
		if(filter.getDaDataFinePermanenza() != null && filter.getADataFinePermanenza() != null && filter.getDaDataFinePermanenza().compareTo(filter.getADataFinePermanenza()) < 0) {
			spec = spec.and(betweenDataFinePermanenzaDates(filter.getDaDataFinePermanenza(), filter.getADataFinePermanenza()));
		}

		return spec;
	}
	
	public static Specification<Film> titoloFilter(String titolo) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<String>get("titolo")),
					"%"+titolo.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Film> registaFilter(String regista) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<String>get("regista")), 
					"%"+regista.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Film> genereFilter(String genere) {
		return (root, query, builder) -> {
			return builder.like(
					builder.upper(root.<String>get("genere")), 
					"%"+genere.toUpperCase()+"%");
		};
	}	
	
	public static Specification<Film> betweenDataUscitaDates(Date da, Date a) {
		return (root, query, builder) -> {
			return builder.between(root.<Date>get("dataUscita"), da, a);
		};
	}	
	
	public static Specification<Film> betweenDataFinePermanenzaDates(Date da, Date a) {
		return (root, query, builder) -> {
			return builder.between(root.<Date>get("dataFinePermanenza"), da, a);
		};
	}	
}
