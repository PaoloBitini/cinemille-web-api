package com.paolo.cinemille.dtos;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilmFiltersDto {
	
	  private String titolo;
	  
	  private String regista;
	  
	  private String genere;
	  
	  private Date daDataUscita;
	  
	  private Date aDataUscita;
	  
	  private Date daDataFinePermanenza;
	  
	  private Date aDataFinePermanenza;
}
