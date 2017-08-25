package org.renato.Controllers;

import org.renato.model.pojos.Match;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/addMatch")
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {

        Match n = new Match();
//        n.setName(name);
//        n.setEmail(email);
//        matchRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allMatches")
    public @ResponseBody Iterable<Match> getAllCandidates() {
        return userService.getAllMatches();
    }


}
