package org.renato.model.pojos.wrapper;

import org.renato.model.pojos.Company;
import org.renato.model.pojos.Frameworks;
import org.renato.model.pojos.Languages;

public class ProjectWrapper {

    private Long project_id;

    private String name;

    private Iterable<Languages> languages;

    private Iterable<Frameworks> frameworks;

    private Company company;



    public ProjectWrapper() {
    }


    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(Iterable<Languages> languages) {
        this.languages = languages;
    }

    public Iterable<Frameworks> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(Iterable<Frameworks> frameworks) {
        this.frameworks = frameworks;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
