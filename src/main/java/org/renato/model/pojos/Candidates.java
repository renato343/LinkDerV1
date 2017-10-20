package org.renato.model.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long candidate_Id;
    private String email;
    private String github;
    private String linkedin;
    private String motto;
    private String name;
    private String password;

    public Candidates() {
    }

    public long getCandidate_Id() {
        return candidate_Id;
    }

    public void setCandidate_Id(long candidate_Id) {
        this.candidate_Id = candidate_Id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }


    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }


    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
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

}
