package org.renato.service.user;


import org.renato.model.dao.CandidateRepository;
import org.renato.model.dao.CompanyRepository;
import org.renato.model.dao.MatchRepository;
import org.renato.model.pojos.Candidate;
import org.renato.model.pojos.Company;
import org.renato.model.pojos.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by codecadet on 23/03/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    @Override
    public Iterable<Candidate> getAllCadets() {
        return candidateRepository.findAll();
    }

    @Transactional
    @Override
    public Iterable<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Transactional
    @Override
    public Iterable<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Transactional
    @Override
    public void addCadet(Candidate userType) {

        if (candidateRepository.readByMail(userType.getEmail()) == null) {
            candidateRepository.create(userType);
        }
    }

    @Transactional
    @Override
    public void addCompany(Company userType) {

        if (companyDao.readByMail(userType.getEmail()) == null) {
            companyDao.create(userType);
        }
    }


//
//    private Candidate candidateLogged;
//    private Company companyLogged;
//    private String userAuth;
//
//    private boolean isAuthenticate = false;
//    private boolean isCompany = true;
//
//    private List companies;
//    private List cadets;
//    private List matches;
//
//
//
//    public Candidate getCandidateLogged() {
//        return candidateLogged;
//    }
//
//    public void setCandidateLogged(Candidate candidateLogged) {
//        this.candidateLogged = candidateLogged;
//    }
//
//    public Company getCompanyLogged() {
//        return companyLogged;
//    }
//
//    public void setCompanyLogged(Company companyLogged) {
//        this.companyLogged = companyLogged;
//    }
//
//    public boolean getIsCompany() {
//        return isCompany;
//    }
//
//    public void setIsCompany(boolean company) {
//        isCompany = company;
//    }
//
//    @Transactional
//    @Override
//    public boolean authenticate(String name, String pass) {
//
//
//        if (isCompany) {
//
//            if (companyDao.readByName(name).getName().equals(name) &&
//                    companyDao.readByName(name).getPassword().equals(pass)) {
//                isAuthenticate = true;
//                userAuth = name;
//            } else {
//                isAuthenticate = false;
//
//            }
//        } else {
//
//            if (candidateRepository.readByName(name).getName().equals(name) &&
//                    candidateRepository.readByName(name).getPassword().equals(pass)) {
//                isAuthenticate = true;
//                userAuth = name;
//            } else {
//                isAuthenticate = false;
//            }
//
//
//        }
//        return isAuthenticate;
//
//    }
//
//    @Transactional
//    @Override
//    public boolean exists(String name) {
//
//        if (isCompany) {
//
//            if (companyDao.readByName(name) == null) {
//                return false;
//            } else {
//                return true;
//            }
//
//        } else {
//
//            if (candidateRepository.readByName(name) == null) {
//                return false;
//            } else {
//                return true;
//            }
//
//        }
//
//
//    }
//
//    @Transactional
//    @Override
//    public Candidate findCadetByMail(String mail) {
//
//        Candidate userType = candidateRepository.readByMail(mail);
//        return userType;
//
//    }
//
//    @Transactional
//    @Override
//    public Company findCompanyByMail(String mail) {
//
//        Company userType = companyDao.readByMail(mail);
//        return userType;
//
//    }
//
//    @Override
//    public Match checkMatch(Candidate candidate, Company company) {
//
//        return matchDao.getmatch(candidate, company);
//
//    }
//
//    @Override
//    public void match(Candidate candidate, Company company) {
//
//            if (!isCompany) {
//                Match match = new Match(candidate.getCadet_Id(), company.getCompany_id(), true, false);
//                matchDao.create(match);
//            } else {
//                Match match = new Match(candidate.getCadet_Id(), company.getCompany_id(), false, true);
//                matchDao.create(match);
//            }
//    }
//
//    @Override
//    public void updateMatch(Match match){
//
//        if (!isCompany) {
//            match.setCandidate_bol(true);
//            matchDao.update(match);
//        } else {
//            match.setCompany_bol(true);
//            matchDao.update(match);
//        }
//    }
//
//    @Transactional
//    @Override
//    public List getMatches() {
//
//        matches = matchDao.all();
//        return matches;
//    }


}
