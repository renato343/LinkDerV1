package org.renato.service.user;

import org.renato.model.pojos.Candidate;
import org.renato.model.pojos.Company;
import org.renato.model.pojos.Match;

/**
 * Created by codecadet on 07/03/17.
 */
public interface UserService {

    Iterable<Candidate> getAllCadets();

    Iterable<Company> getAllCompanies();

    Iterable<Match> getAllMatches();

    boolean addCandidate(Candidate candidate);

    boolean addCompany(Company company);

    boolean authCompany(String name, String pass);

    boolean authCandidate(String name, String pass);

//    void updateMatch(Match match);
//
//    void match(Candidate candidateLogged, Company company);
//
//    Match checkMatch(Candidate candidate, Company company);
//
//    List getMatches();

}

