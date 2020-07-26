package com.MicroSillones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MicroSillones.model.Sillones;


@Repository
public interface SillonRepository extends CrudRepository<Sillones, Long> {

}
