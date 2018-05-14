package org.renato.model.dao;

import org.renato.model.pojos.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Long> {

    @Query(value = "INSERT INTO `linkder`.`match` (`match_id`, `candidate_id`, `candidate_bol`, `project_id`, `project_bol`) VALUES (DEFAULT, 1, 1, 1, 0);")
    void addMatch(Match n);

    @Query(value = "INSERT INTO `match`" +
            "(match_id,candidate_id,candidate_bol,project_id,project_bol)" +
            "VALUES (?1,)framework_id " +
            "IN (SELECT framework_id " +
            "FROM candidate_frameworks " +
            "where candidate_id = ?1)", nativeQuery = true)
    Iterable<Frameworks> searchByCadetId(Long id);

}
