package org.renato.model.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frameworks {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long framework_Id;
  private String name;
  private long language_id;


  public long getFramework_Id() {
    return framework_Id;
  }

  public void setFramework_Id(long framework_Id) {
    this.framework_Id = framework_Id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getLanguages_Language_Id() {
    return language_id;
  }

  public void setLanguages_Language_Id(long languages_Language_Id) {
    this.language_id = languages_Language_Id;
  }

}
