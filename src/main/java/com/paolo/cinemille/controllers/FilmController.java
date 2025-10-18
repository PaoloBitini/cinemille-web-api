package com.paolo.cinemille.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolo.cinemille.dtos.FilmDto;
import com.paolo.cinemille.services.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {

	private FilmService filmService;
	
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	
	@GetMapping
	public Page<FilmDto> getFilms(@PageableDefault(page = 0, direction = Direction.DESC, size = 20) Pageable pageable) {
		return filmService.GetFilmsPaginated(pageable);
	}
	
}
