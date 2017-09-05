package org.renato.Controllers;

import org.renato.model.pojos.Candidate;
import org.renato.model.pojos.Frameworks;
import org.renato.model.pojos.Languages;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/allCandidates")
    public @ResponseBody
    Iterable<Candidate> getAllCandidates() {
        return userService.getAllCadets();
    }

    @GetMapping(path = "/allLanguages")
    public @ResponseBody
    Iterable<Languages> getAllLanguages() {
        return userService.getAllLanguages();
    }

    @GetMapping(path = "/allFrameworks")
    public @ResponseBody
    Iterable<Frameworks> getAllFrameworks() {
        return userService.getAllFrameworks();
    }

    @RequestMapping(method=RequestMethod.POST ,path = "/addCandidate")
    public @ResponseBody
    String addNewUser(@RequestBody Candidate candidate) {

        if (userService.addCandidate(candidate)) {
            return "Saved";
        } else {
            return "User already register";
        }

    }

    @RequestMapping(method = RequestMethod.POST, path = "/auth")
    public @ResponseBody
    ResponseEntity<Candidate> authenticate(@RequestBody Candidate user) {

        Candidate candidate = new Candidate();

        if(userService.getCandidateByEmail(user.getEmail())==null){
            return new ResponseEntity<Candidate>(candidate, HttpStatus.NOT_FOUND);
        }

        if (userService.authCandidate(user.getEmail(), user.getPassword())) {

            candidate = userService.getCandidateByEmail(user.getEmail());
            return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);

        } else {
            return new ResponseEntity<Candidate>(candidate, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/id")
    public @ResponseBody
    Candidate getCandidateById(@RequestParam long id) {
        return userService.getCandidateById(id);
    }



}
