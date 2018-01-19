package org.renato.model.dao;

import org.renato.model.pojos.Frameworks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Candidate_frameworks extends CrudRepository<Candidate_frameworks,Long> {

    @Query(value = "SELECT * " +
            "FROM frameworks\n" +
            "WHERE framework_id IN (SELECT frameworks_framework_id FROM candidate_frameworks " +
            "where candidates_candidate_id = 1)", nativeQuery = true)
    Iterable<Frameworks> searchByCadetId(Long id);

}