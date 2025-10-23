package com.paolo.cinemille.dtos;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProgrammazioniFiltersDto {
	
	private String titolo;
	
    private String regista;
    
	private String genere;
	
	private String sala;
	
    private Date daProiezione;
    
	private Date aProiezione;
}
