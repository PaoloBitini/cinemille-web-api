package com.paolo.cinemille.dtos;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FilmDto {
	
	@NotNull
	private UUID uuid;
	
	@NotNull
	private String titolo;
	
	@NotNull
	private String regista;
	
	@NotNull
	private String genere;
	
	private String descrizione;
	
	@NotNull
	private Date dataUscita;
	
	@NotNull
	private Date dataFinePermanenza;
}
