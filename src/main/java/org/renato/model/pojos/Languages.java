package org.renato.model.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "languages")
public class Languages implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Candidate.class)
    @JoinTable(name = "candidate_languages",
            joinColumns = { @JoinColumn(name = "language_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidate_id") })
    private Set<Candidate> candidates;

    public Languages() {
    }

    public Languages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Languages)) return false;

        Languages languages = (Languages) o;

        if (getId() != null ? !getId().equals(languages.getId()) : languages.getId() != null) return false;
        if (getName() != null ? !getName().equals(languages.getName()) : languages.getName() != null) return false;
        return getCandidates() != null ? getCandidates().equals(languages.getCandidates()) : languages.getCandidates() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCandidates() != null ? getCandidates().hashCode() : 0);
        return result;
    }
}
