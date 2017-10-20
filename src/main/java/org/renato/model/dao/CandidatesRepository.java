package org.renato.model.dao;

import org.renato.model.pojos.Candidates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CandidatesRepository extends CrudRepository<Candidates,Long> {

    @Query(value = "SELECT * FROM Candidates WHERE email = :email", nativeQuery = true)
    Candidates findCandidateByEmail(@Param("email") String email);

    Candidates findOne(Long aLong);
}
