package org.renato.Controllers;

import org.renato.model.pojos.Candidate;
import org.renato.service.user.UserService;
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
    String authenticate(@RequestParam String email, @RequestParam String pass) {

        if (userService.authCandidate(email, pass)) {
            return "welcome " + email;
        } else {
            return "Wrong Pass";
        }
    }

    @GetMapping(path = "/allCandidates")
    public @ResponseBody
    Iterable<Candidate> getAllCandidates() {
        return userService.getAllCadets();
    }


}
