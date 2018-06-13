package org.renato.model.dao;

import org.renato.model.pojos.Mitch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchRepository extends CrudRepository<Mitch,Long> {

    @Query(value = "SELECT * from mitch WHERE candidate_id = :candidateId AND project_id =:projectId",nativeQuery = true)
    Mitch findMitch(@Param("candidateId") Long candidateId, @Param("projectId") Long projectId);


}
