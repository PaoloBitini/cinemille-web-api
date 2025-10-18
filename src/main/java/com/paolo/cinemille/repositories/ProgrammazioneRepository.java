package com.paolo.cinemille.repositories;


import java.util.Date;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paolo.cinemille.entities.Programmazione;

@Repository
public interface ProgrammazioneRepository extends JpaRepository<Programmazione, Integer>{

	public Page<Programmazione> findAll(Pageable p);
	
	@Query("SELECT p FROM Programmazione p JOIN p.film f WHERE f.titolo LIKE (:name)")
	public Page<Programmazione> findByFilmTitolo(@Param("name") String name, Pageable p);
	
	@Query("SELECT p FROM Programmazione p WHERE p.proiezione >= (:from) AND p.proiezione <= (:to)")
	public Page<Programmazione> findByRangeDate(@Param("from") Date from, @Param("to") Date to, Pageable p);
	
	@Query("SELECT p FROM Programmazione p JOIN p.sala s WHERE s.nome LIKE (:sala)")
	public Page<Programmazione> findBySala(@Param("sala") String sala , Pageable p);
	
	}
