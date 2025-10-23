package com.paolo.cinemille.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolo.cinemille.dtos.SalaDto;
import com.paolo.cinemille.services.SalaService;

@RestController
@RequestMapping("/api/sale")
public class SalaController {

	private SalaService salaService;
	
	public SalaController(SalaService salaService) {
		this.salaService = salaService;		
	}
	
	@GetMapping
	public Page<SalaDto> getSale(@PageableDefault(page = 0, direction = Direction.DESC, size = 20) Pageable pageable) {
		return this.salaService.GetSalePaginated(pageable);
	}
	
}
