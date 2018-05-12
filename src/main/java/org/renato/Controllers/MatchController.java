package org.renato.Controllers;


import org.renato.model.pojos.Match;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    private UserService userService;


    @RequestMapping(method=RequestMethod.POST, path = "/addMatch")
    public @ResponseBody
    String addNewMatch(@RequestBody  Match n) {

        userService.match(n);
        return "save";
    }

    @GetMapping(path="/allMatches")
    public @ResponseBody Iterable<Match> getAllCandidates() {
        return userService.getAllMatches();
    }


}
