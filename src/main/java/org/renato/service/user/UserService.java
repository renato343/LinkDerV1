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

    void addCadet(Candidate userType);

    void addCompany(Company userType);

//    Candidate getCandidateLogged();
//
//    void setCandidateLogged(Candidate candidateLogged);
//
//    Company getCompanyLogged();
//
//    void setCompanyLogged(Company companyLogged);
//
//    boolean getIsCompany();
//
//    void setIsCompany(boolean company);
//
//    boolean authenticate(String name, String pass);
//

//
//    boolean exists(String name);
//
//    Candidate findCadetByMail(String name);
//
//    Company findCompanyByMail(String mail);
//
//    void updateMatch(Match match);
//
//    void match(Candidate candidateLogged, Company company);
//
//    Match checkMatch(Candidate candidate, Company company);
//
//    List getMatches();


}

