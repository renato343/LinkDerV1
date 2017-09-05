package org.renato.model.dao;

import org.renato.model.pojos.Frameworks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FrameworkRepository extends CrudRepository<Frameworks,Long> {

    @Query(value = "SELECT * FROM frameworks WHERE name = :name", nativeQuery = true)
    Frameworks findFrameworksByName(@Param("name") String name);

}
