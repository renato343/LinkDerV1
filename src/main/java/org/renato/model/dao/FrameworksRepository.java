package org.renato.model.dao;

import org.renato.model.pojos.Frameworks;
import org.springframework.data.repository.CrudRepository;

public interface FrameworksRepository extends CrudRepository<Frameworks,Long> {

    Frameworks findByName(String Name);
}
