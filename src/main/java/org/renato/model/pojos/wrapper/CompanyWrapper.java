package org.renato.model.pojos.wrapper;

import org.renato.model.pojos.Projects;

public class CompanyWrapper {


    private Long company_id;

    private String email;

    private String name;

    private String password;

    private String motto;

    private Iterable<Projects> projectsList;

    public CompanyWrapper() {
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Iterable<Projects> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(Iterable<Projects> projectsList) {
        this.projectsList = projectsList;
    }
}
