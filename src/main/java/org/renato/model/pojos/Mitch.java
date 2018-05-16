package org.renato.model.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Altran on 19/05/2017.
 */

@Entity
public class Mitch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mitch_id;

    private long candidate_id;

    private boolean candidate_bol;

    private long project_id;

    private boolean project_bol;

    public long getMitch_id() {
        return mitch_id;
    }

    public void setMitch_id(long mitch_id) {
        this.mitch_id = mitch_id;
    }

    public long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public boolean isCandidate_bol() {
        return candidate_bol;
    }

    public void setCandidate_bol(boolean candidate_bol) {
        this.candidate_bol = candidate_bol;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public boolean isProject_bol() {
        return project_bol;
    }

    public void setProject_bol(boolean project_bol) {
        this.project_bol = project_bol;
    }
}
