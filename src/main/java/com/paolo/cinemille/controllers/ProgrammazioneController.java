package com.paolo.cinemille.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolo.cinemille.dtos.ProgrammazioneDto;
import com.paolo.cinemille.services.ProgrammazioneService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/programmazioni")
public class ProgrammazioneController {

	private ProgrammazioneService programmazioneService;
	
	public ProgrammazioneController(ProgrammazioneService programmazioneService) {
		this.programmazioneService = programmazioneService;
	}
	
	@GetMapping
	public Page<ProgrammazioneDto> getProgrammazioni(@PageableDefault(page = 0, direction = Direction.DESC, size = 20) Pageable pageable) {
		return this.programmazioneService.GetProgrammazioniPaginated(pageable);
	}
	
}
