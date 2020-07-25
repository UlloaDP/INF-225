package com.MicroSillones.Repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MicroSillones.model.Sillones;

@Repository
public interface ISillones extends CrudRepository<Sillones,Long>{

}
