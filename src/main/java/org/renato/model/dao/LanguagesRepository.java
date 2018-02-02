package org.renato.model.dao;

import org.renato.model.pojos.Languages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LanguagesRepository extends CrudRepository<Languages,Long> {

    Languages findByName(String name);

    @Query(value = "SELECT * FROM languages " +
            "WHERE language_id " +
            "IN (SELECT candidates_id " +
            "FROM candidate_languages " +
            "where candidates_id = ?1)", nativeQuery = true)
    Iterable<Languages> searchByCadetId(Long id);

    @Query(value = "SELECT * FROM languages " +
            "WHERE language_id " +
            "IN (SELECT language_id " +
            "FROM projects_languages " +
            "where project_id = ?1)", nativeQuery = true)
    Iterable<Languages> searchLanguagesByProject(Long id);

}
