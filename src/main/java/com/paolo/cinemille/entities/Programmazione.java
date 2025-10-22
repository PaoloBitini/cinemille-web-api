package com.paolo.cinemille.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "programmazioni")
@Data
@NoArgsConstructor
public class Programmazione {

	// Id e uuid vengono generati dal db
	
	/* 
	 * annotazione @Column e @Table non necessarie in questo caso,
	 * ritengo che sia comunque buona prassi specificarle nel aso fosse necessario refactoring 
	 * dei campi o cambio collonne/tabelle del db
	 */
	
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "programmazioni_id_seq", name = "programmazione_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programmazione_gen" )
	private int id;
	
	@Column(name="uuid")
	private UUID uuid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_film" , referencedColumnName = "id")
	private Film film;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sala" , referencedColumnName = "id")
	private Sala sala;
	
	@Temporal(TemporalType.DATE)
	@Column(name="proiezione")
	private Date proiezione;
}
