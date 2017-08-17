package org.renato.Controllers;

import org.renato.model.dao.CandidateRepository;
import org.renato.model.pojos.Candidate;
import org.renato.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {

    @Autowired
    private UserService userService;


    @GetMapping(path="/addCandidate") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Candidate n = new Candidate();
        n.setName(name);
        n.setEmail(email);
       // candidateRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allCandidates")
    public @ResponseBody Iterable<Candidate> getAllCandidates() {
        return userService.getAllCadets();
    }


}
