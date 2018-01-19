package org.renato.model.pojos;

import javax.persistence.Entity;

@Entity
public class Candidate_frameworks {


    private Long candidates_candidate_id;
    private Long frameworks_framework_id;

    public Long getCandidates_candidate_id() {
        return candidates_candidate_id;
    }

    public void setCandidates_candidate_id(Long candidates_candidate_id) {
        this.candidates_candidate_id = candidates_candidate_id;
    }

    public Long getFrameworks_framework_id() {
        return frameworks_framework_id;
    }

    public void setFrameworks_framework_id(Long frameworks_framework_id) {
        this.frameworks_framework_id = frameworks_framework_id;
    }
}
