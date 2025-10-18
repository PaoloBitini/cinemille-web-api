package com.paolo.cinemille.repositories;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paolo.cinemille.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{

	public Film findByUuid(UUID uuid);
	
	public Page<Film> findAll(Pageable p);
	
	@Query("SELECT f FROM Film f WHERE f.titolo LIKE (:name)")
	public Page<Film> findByTitolo(@Param("name") String name, Pageable p);
	
	@Query("SELECT f FROM Film f WHERE f.dataUscita >= (:from)")
	public Page<Film> findByDataUscita(@Param("from") Date from, Pageable p);
	
	@Query("SELECT f FROM Film f WHERE f.dataFinePermanenza <= (:to)")
	public Page<Film> findByDataFinePermanenza(@Param("from") Date from, Pageable p);
}
