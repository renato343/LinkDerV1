package org.renato.model.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Languages {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long language_Id;
  private String name;


  public long getLanguage_Id() {
    return language_Id;
  }

  public void setLanguage_Id(long language_Id) {
    this.language_Id = language_Id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
