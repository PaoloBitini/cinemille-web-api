package com.paolo.cinemille.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale")
@Data
@NoArgsConstructor
public class Sala {

	// Id e uuid vengono generati dal db
	
	/* 
	 * annotazione @Column e @Table non necessarie in questo caso,
	 * ritengo che sia comunque buona prassi specificarle nel aso fosse necessario refactoring 
	 * dei campi o cambio collonne/tabelle del db
	 */
	
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "sale_id_seq", name = "sale_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_gen" )
	private int id;
	
	@Column(name="uuid")
	private UUID uuid;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "capienza")
	private int capienza;
	
	@Column(name = "imax")
	private boolean imax;

}
