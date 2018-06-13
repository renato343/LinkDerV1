package org.renato.Controllers;


import org.renato.model.pojos.Mitch;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    private UserService userService;


    @RequestMapping(method=RequestMethod.POST, path = "/addMatch")
    public @ResponseBody Mitch addNewMatch(@RequestBody Mitch n) {

        return userService.match(n);
    }

    @GetMapping(path="/allMatches")
    public @ResponseBody Iterable<Mitch> getAllCandidates() {
        return userService.getAllMatches();
    }

}
