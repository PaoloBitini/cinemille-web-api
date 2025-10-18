package com.paolo.cinemille.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
public class Film {

	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "film_id_seq", name = "film_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_gen" )
	private int id;
	
	@Column(name="uuid")
	private UUID uuid;

	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "regista")
	private String regista;
	
	@Column(name ="genere")
	private String genere;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_uscita")
	private Date dataUscita;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fine_permanenza")
	private Date dataFinePermanenza;
}
