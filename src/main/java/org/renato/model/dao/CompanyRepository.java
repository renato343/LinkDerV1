package org.renato.model.dao;

import org.renato.model.pojos.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {
}
