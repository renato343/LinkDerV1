package org.renato.services.user;

import org.renato.model.dao.*;
import org.renato.model.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {


    private boolean isAuthenticate = false;

    private boolean isCompany = true;


    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateRepository candidateRepository1;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    private FrameworkRepository frameworkRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Iterable<Languages> getAllLanguages() {
        return languagesRepository.findAll();
    }

    @Override
    public Iterable<Frameworks> getAllFrameworks() {
        return frameworkRepository.findAll();
    }

    @Transactional
    @Override
    public Iterable<Candidate> getAllCadets() {
        System.out.println(candidateRepository.findAll());
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

    @Override
    public Candidate getCandidateById(Long id) {

        return candidateRepository.findOne(id);
    }

    @Override
    public Candidate getCandidateByEmail(String email) {
        return candidateRepository.findCandidateByEmail(email);
    }

    @Transactional
    @Override
    public boolean addCandidate(Candidate candidate) {

        if (candidateRepository.findCandidateByEmail(candidate.getEmail()) == null) {
            candidateRepository.save(candidate);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean addCompany(Company company) {

        if (companyRepository.findCompaniesByEmail(company.getEmail()) == null) {
            companyRepository.save(company);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean authCompany(String mail, String pass) {

        Company company = companyRepository.findCompaniesByEmail(mail);

        if (company.getEmail().equals(mail) && company.getPassword().equals(pass)) {
            isAuthenticate = true;
        } else {
            isAuthenticate = false;
        }

        return isAuthenticate;

    }

    @Transactional
    @Override
    public boolean authCandidate(String mail, String pass) {


        Candidate candidate = candidateRepository.findCandidateByEmail(mail);

        if (candidate == null) {
            return isAuthenticate;
        }

        if (candidate.getEmail().equals(mail) && candidate.getPassword().equals(pass)) {
            isAuthenticate = true;
        } else {
            isAuthenticate = false;
        }

        return isAuthenticate;

    }


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
//                Match match = new Match(candidate.getCandidate_id(), company.getCompany_id(), true, false);
//                matchDao.create(match);
//            } else {
//                Match match = new Match(candidate.getCandidate_id(), company.getCompany_id(), false, true);
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
}
