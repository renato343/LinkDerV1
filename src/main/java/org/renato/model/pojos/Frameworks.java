package org.renato.model.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Frameworks")
public class Frameworks implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "framework_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Candidate.class)
    @JoinTable(name = "candidate_frameworks",
            joinColumns = { @JoinColumn(name = "framework_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidate_id") })
    private Set<Candidate> candidates;

    public Frameworks() {
    }

    public Frameworks(String name) {
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
        if (!(o instanceof Frameworks)) return false;

        Frameworks that = (Frameworks) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getCandidates() != null ? getCandidates().equals(that.getCandidates()) : that.getCandidates() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCandidates() != null ? getCandidates().hashCode() : 0);
        return result;
    }
}
