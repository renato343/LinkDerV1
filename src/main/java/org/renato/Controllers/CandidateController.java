package org.renato.Controllers;

import org.renato.model.pojos.Candidate;

import org.renato.model.pojos.User;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/addCandidate") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {

        Candidate n = new Candidate();
        n.setName(name);
        n.setEmail(email);
        if (userService.addCandidate(n)) {
            return "Saved";
        }else{
            return "User already register";
        }

    }

    @GetMapping(path = "/auth")
    public @ResponseBody
    User authenticate(@RequestParam String email, @RequestParam String pass) {

        User user;
        if (userService.authCandidate(email, pass)) {

            user = new User();
            Candidate candidate = userService.getCandidateByEmail(email);

            user.setEmail(candidate.getEmail());
            user.setName(candidate.getName());
            user.setMotto(candidate.getMotto());
            user.setUserId(candidate.getCadet_Id());

            return user;
        } else {
            return user = new User();
        }
    }

    @GetMapping(path = "/allCandidates")
    public @ResponseBody
    Iterable<Candidate> getAllCandidates() {
        return userService.getAllCadets();
    }

    @GetMapping(path = "/id")
    public @ResponseBody
    Candidate getCandidateById(@RequestParam long id){
        return userService.getCandidateById(id);
    }


}
