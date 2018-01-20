package org.renato.model.dao;

import org.renato.model.pojos.Languages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LanguagesRepository extends CrudRepository<Languages,Long> {

    Languages findByName(String name);

    @Query(value = "SELECT * FROM languages " +
            "WHERE language_id IN " +
            "(SELECT candidates_candidate_id " +
            "FROM candidate_languages " +
            "where candidates_candidate_id = ?1)", nativeQuery = true)
    Iterable<Languages> searchByCadetId(Long id);

}
