package org.renato.Controllers;

import org.renato.model.pojos.Candidates;
import org.renato.model.pojos.Frameworks;
import org.renato.model.pojos.Languages;
import org.renato.model.pojos.wrapper.CandidateWrapper;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/allCandidates")
    public @ResponseBody
    List<CandidateWrapper> getAllCandidates() {

     Iterable<Candidates> candidates = userService.getAllCandidates();
     List<CandidateWrapper> wrappersIt = new ArrayList<>();

        for(Candidates candidate: candidates){

            CandidateWrapper wrapper = new CandidateWrapper();
            wrapper.setCandidate_Id(candidate.getCandidate_Id());
            wrapper.setEmail(candidate.getEmail());
            wrapper.setGithub(candidate.getGithub());
            wrapper.setLinkedin(candidate.getLinkedin());
            wrapper.setMotto(candidate.getMotto());
            wrapper.setName(candidate.getName());
            wrapper.setPassword(candidate.getPassword());
            wrapper.setFrameworks(userService.getCandidate_FrameworksByCandidateID(candidate.getCandidate_Id()));
            wrapper.setLanguages(userService.getCandidate_LanguagesByCandidateID(candidate.getCandidate_Id()));

            wrappersIt.add(wrapper);
        }

        return wrappersIt ;
    }

    @GetMapping(path = "/allFrameworks")
    public @ResponseBody
    Iterable<Frameworks> getAllFrameworks() {
        return userService.getAllFrameWork();
    }

    @GetMapping(path = "/allLanguages")
    public @ResponseBody
    Iterable<Languages> getAllLanguages() {
        return userService.getAllLanguages();
    }

    @RequestMapping(method=RequestMethod.POST ,path = "/addCandidate")
    public @ResponseBody
    String addNewUser(@RequestBody CandidateWrapper candidate) {

        for (Languages language:candidate.getLanguages()) {

            if(userService.addLanguage(language)){
                System.out.println(language.getName() + "added to database");
            }
        }

        for (Frameworks frameworks : candidate.getFrameworks()) {

            if(userService.addFramework(frameworks)){
                System.out.println(frameworks.getName() + "added to database");
            }
        }

        Candidates person = new Candidates();
        person.setName(candidate.getName());
        person.setEmail(candidate.getEmail());
        person.setGithub(candidate.getGithub());
        person.setLinkedin(candidate.getLinkedin());
        person.setMotto(candidate.getMotto());
        person.setPassword(candidate.getPassword());

        if (userService.addCandidate(person)) {

            return "Profile Created";

        } else {

            return "User Already exists";
        }

    }

    @RequestMapping(method = RequestMethod.POST, path = "/auth")
    public @ResponseBody
    ResponseEntity<Candidates> authenticate(@RequestBody Candidates user) {

        Candidates candidate = new Candidates();

        if(userService.getCandidateByEmail(user.getEmail())==null){
            return new ResponseEntity<Candidates>(candidate, HttpStatus.NOT_FOUND);
        }

        if (userService.authCandidate(user.getEmail(), user.getPassword())) {

            candidate = userService.getCandidateByEmail(user.getEmail());
            return new ResponseEntity<Candidates>(candidate, HttpStatus.OK);

        } else {
            return new ResponseEntity<Candidates>(candidate, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/id")
    public @ResponseBody
    Candidates getCandidateById(@RequestParam long id) {
        return userService.getCandidateById(id);
    }



}
