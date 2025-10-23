package com.paolo.cinemille.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paolo.cinemille.entities.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	public Page<Sala> findAll(Pageable p);

	public Sala findByUuid(UUID uuid);
}
