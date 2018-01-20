package org.renato.services.user;

import org.renato.model.pojos.*;

public interface UserService {

    Iterable<Candidates> getAllCandidates();

    Candidates getCandidateById(Long id);

    Candidates getCandidateByEmail(String email);

    boolean addCandidate(Candidates candidate);

    boolean authCandidate(String name, String pass);



    Iterable<Frameworks> getAllFrameWork();


    Iterable<Frameworks> getCandidate_FrameworksByCandidateID(Long id);


    Iterable<Company> getAllCompanies();

    Iterable<Match> getAllMatches();

    Iterable<Languages> getAllLanguages();


    Company getCompanyByEmail(String email);

    boolean addCompany(Company company);

    boolean authCompany(String name, String pass);

    boolean addLanguage(Languages language);

    boolean addFramework(Frameworks frameworks);

    Iterable<Languages> getCandidate_LanguagesByCandidateID(Long id);


//    void updateMatch(Match match);
//
//    Match checkMatch(Candidate candidate, Company company);

}
