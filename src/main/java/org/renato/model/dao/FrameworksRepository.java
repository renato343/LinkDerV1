package org.renato.model.dao;

import org.renato.model.pojos.Frameworks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FrameworksRepository extends CrudRepository<Frameworks,Long> {

    Frameworks findByName(String Name);

    @Query(value = "SELECT * FROM frameworks " +
            "WHERE framework_id " +
            "IN (SELECT framework_id " +
            "FROM candidate_frameworks " +
            "where candidate_id = ?1)", nativeQuery = true)
    Iterable<Frameworks> searchByCadetId(Long id);
}
