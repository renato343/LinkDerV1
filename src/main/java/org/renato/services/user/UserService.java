package org.renato.services.user;

import org.renato.model.pojos.*;

public interface UserService {

    Iterable<Candidate> getAllCadets();

    Iterable<Company> getAllCompanies();

    Iterable<Match> getAllMatches();

    Iterable<Languages> getAllLanguages();

    Iterable<Frameworks> getAllFrameworks();

    Candidate getCandidateById(Long id);

    Candidate getCandidateByEmail(String email);

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
