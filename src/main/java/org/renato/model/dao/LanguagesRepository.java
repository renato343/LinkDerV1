package org.renato.model.dao;

import org.renato.model.pojos.Languages;
import org.springframework.data.repository.CrudRepository;

public interface LanguagesRepository extends CrudRepository<Languages,Long> {

    Languages findByName(String name);

}
