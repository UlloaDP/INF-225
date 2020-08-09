package com.MicroSillones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MicroSillones.model.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {
	List<Sala> searchSalaByDisponibilidad(boolean disponibilidad);
}
