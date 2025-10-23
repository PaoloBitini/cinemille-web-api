package com.paolo.cinemille.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalaDto {

	@NotNull
	private UUID uuid;
	
	@NotNull
	private String nome;
	
	@NotNull
	private int capienza;
	
	@NotNull
	private boolean imax;
}
