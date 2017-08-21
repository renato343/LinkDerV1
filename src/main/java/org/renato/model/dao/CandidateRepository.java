package org.renato.model.dao;

import org.renato.model.pojos.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    @Query(value = "SELECT * FROM cadets WHERE email = :email", nativeQuery = true)
    Candidate findCandidateByEmail(@Param("email") String email);
}
