package org.renato.model.dao;

import org.renato.model.pojos.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends CrudRepository<Company,Long> {

    @Query (value = "SELECT * FROM companys WHERE email = :email", nativeQuery = true)
    Company findCompaniesByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM companys " +
            "WHERE company_id " +
            "IN (SELECT companys_id " +
            "FROM companys_projects " +
            "WHERE Projects_id = ?1)",nativeQuery = true)
    Company findCompaniesByProject(long projectId);

}
