package com.MicroSillones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MicroSillones.model.Sillones;


@Repository
public interface SillonRepository extends CrudRepository<Sillones, Long> {
	List<Sillones> searchSillonByDisponibilidad(boolean dispo);
}
