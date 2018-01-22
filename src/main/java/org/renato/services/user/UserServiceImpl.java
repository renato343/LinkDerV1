package org.renato.services.user;

import org.renato.model.dao.*;
import org.renato.model.pojos.*;
import org.renato.model.pojos.Candidates;
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
    private CandidatesRepository candidatesRepository;

    @Autowired
    private FrameworksRepository frameworksRepository;

    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Candidates> getAllCandidates() {
        return candidatesRepository.findAll();
    }

    @Override
    public Candidates getCandidateById(Long id) {

        return candidatesRepository.findOne(id);
    }

    @Override
    public Candidates getCandidateByEmail(String email) {

        return candidatesRepository.findCandidateByEmail(email);

    }

    @Transactional
    @Override
    public boolean addCandidate(Candidates candidate) {

        if (candidatesRepository.findCandidateByEmail(candidate.getEmail()) == null) {

            candidatesRepository.save(candidate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Company getCompanyByEmail(String email) {

        return companyRepository.findCompaniesByEmail (email);

    }

    @Override
    public Iterable<Frameworks> getAllFrameWork(){
        return frameworksRepository.findAll();
    }

    @Override
    public Iterable<Frameworks> getCandidate_FrameworksByCandidateID(Long id) {

        return frameworksRepository.searchByCadetId(id);
    }

    @Transactional
    @Override
    public Iterable<Languages> getAllLanguages() {
        return languagesRepository.findAll();
    }

    @Override
    public boolean addLanguage(Languages language) {

        if(languagesRepository.findByName(language.getName())==null) {
            languagesRepository.save(language);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean addFramework(Frameworks frameworks) {

        if(frameworksRepository.findByName(frameworks.getName())==null) {
            frameworksRepository.save(frameworks);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Iterable<Languages> getCandidate_LanguagesByCandidateID(Long id) {
        return languagesRepository.searchByCadetId(id);
    }

    @Override
    public Iterable<Projects> getProjectsByCompany(Long company_id) {
       return projectsRepository.findProjectByCompanyId(company_id);
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

        Candidates candidate = candidatesRepository.findCandidateByEmail(mail);

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
