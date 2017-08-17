package org.renato.model.dao;

import org.renato.model.pojos.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate,Long> {
}
