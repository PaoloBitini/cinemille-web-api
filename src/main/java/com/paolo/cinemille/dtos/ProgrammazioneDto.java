package com.paolo.cinemille.dtos;

import java.util.Date;
import java.util.UUID;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProgrammazioneDto {

	@NotNull
	private UUID uuid;
	
	@NotNull
	private UUID uuidFilm;
	
	@NotNull 
	private UUID uuidSala;
	
	@NotNull
	private String titolo;
	
	@NotNull
	private String regista;
	
	@NotNull
	private String genere;
	
	@NotNull
	private String sala;

	@NotNull
	private Date proiezione;
}
