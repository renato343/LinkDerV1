package org.renato.model.dao;

import org.renato.model.pojos.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Long> {
}
