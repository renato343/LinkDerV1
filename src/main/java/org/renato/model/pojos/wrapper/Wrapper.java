package org.renato.model.pojos.wrapper;

import org.renato.model.pojos.Frameworks;
import org.renato.model.pojos.Languages;

import java.util.List;

public class Wrapper {

    private long candidate_Id;
    private String email;
    private String github;
    private String linkedin;
    private String motto;
    private String name;
    private String password;
    private List<Languages> languages;
    private List<Frameworks> frameworks;

    public Wrapper() {
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

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Frameworks> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(List<Frameworks> frameworks) {
        this.frameworks = frameworks;
    }
}
