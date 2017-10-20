package org.renato.services.user;

import org.renato.model.pojos.*;
import org.renato.model.pojos.Candidates;

public interface UserService {

    Iterable<Candidates> getAllCandidates();

    Candidates getCandidateById(Long id);

    Candidates getCandidateByEmail(String email);

    boolean addCandidate(Candidates candidate);

    boolean authCandidate(String name, String pass);



    Iterable<Frameworks> getAllFrameWork();




    Iterable<Company> getAllCompanies();

    Iterable<Match> getAllMatches();

    Iterable<Languages> getAllLanguages();






    boolean addCompany(Company company);

    boolean authCompany(String name, String pass);

    boolean addLanguage(Languages language);

    boolean addFramework(Frameworks frameworks);


//    void updateMatch(Match match);
//
//    Match checkMatch(Candidate candidate, Company company);

}
