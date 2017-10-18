package org.renato.model.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Renato on 25/03/17.
 */

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private Long candidate_id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "motto")
    private String motto;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Languages.class)
    @JoinTable(name = "candidate_languages",
            joinColumns = {@JoinColumn(name = "candidate_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private List<Languages> languages;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Frameworks.class)
    @JoinTable(name = "candidate_frameworks",
            joinColumns = {@JoinColumn(name = "candidate_id")},
            inverseJoinColumns = {@JoinColumn(name = "framework_id")})
    private List<Frameworks> frameworks;

    public Candidate() {
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;

        Candidate candidate = (Candidate) o;

        if (getCandidate_id() != null ? !getCandidate_id().equals(candidate.getCandidate_id()) : candidate.getCandidate_id() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(candidate.getEmail()) : candidate.getEmail() != null) return false;
        if (getName() != null ? !getName().equals(candidate.getName()) : candidate.getName() != null) return false;
        if (getPassword() != null ? !getPassword().equals(candidate.getPassword()) : candidate.getPassword() != null)
            return false;
        if (getMotto() != null ? !getMotto().equals(candidate.getMotto()) : candidate.getMotto() != null) return false;
        if (getGithub() != null ? !getGithub().equals(candidate.getGithub()) : candidate.getGithub() != null)
            return false;
        if (getLinkedin() != null ? !getLinkedin().equals(candidate.getLinkedin()) : candidate.getLinkedin() != null)
            return false;
        if (getLanguages() != null ? !getLanguages().equals(candidate.getLanguages()) : candidate.getLanguages() != null)
            return false;
        return getFrameworks() != null ? getFrameworks().equals(candidate.getFrameworks()) : candidate.getFrameworks() == null;
    }

    @Override
    public int hashCode() {
        int result = getCandidate_id() != null ? getCandidate_id().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getMotto() != null ? getMotto().hashCode() : 0);
        result = 31 * result + (getGithub() != null ? getGithub().hashCode() : 0);
        result = 31 * result + (getLinkedin() != null ? getLinkedin().hashCode() : 0);
        result = 31 * result + (getLanguages() != null ? getLanguages().hashCode() : 0);
        result = 31 * result + (getFrameworks() != null ? getFrameworks().hashCode() : 0);
        return result;
    }
}
