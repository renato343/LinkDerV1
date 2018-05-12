package org.renato.model.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Altran on 19/05/2017.
 */

@Entity
public class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer match_id;

    private Integer candidate_id;

    private Integer project_id;

    private boolean candidate_bol;

    private boolean project_bol;

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Integer candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public boolean getCandidate_bol() {
        return candidate_bol;
    }

    public void setCandidate_bol(boolean candidate_bol) {
        this.candidate_bol = candidate_bol;
    }

    public boolean getProject_bol() {
        return project_bol;
    }

    public void setProject_bol(boolean project_bol) {
        this.project_bol = project_bol;
    }
}
