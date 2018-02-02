package org.renato.model.dao;

import org.renato.model.pojos.Languages;
import org.renato.model.pojos.Projects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Projects,Long> {


    @Query(value = "SELECT * FROM projects " +
            "WHERE project_id " +
            "IN (SELECT companys_id " +
            "FROM companys_projects " +
            "WHERE companys_id = ?1)",nativeQuery = true)
    Iterable<Projects> findProjectByCompanyId(Long id);



}
