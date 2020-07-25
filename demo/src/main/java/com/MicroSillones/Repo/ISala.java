package com.MicroSillones.Repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MicroSillones.model.Sala;

@Repository
public interface ISala extends CrudRepository<Sala,Long> {

}
