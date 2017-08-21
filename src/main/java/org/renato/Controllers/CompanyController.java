package org.renato.Controllers;

import org.renato.model.pojos.Company;
import org.renato.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/addCompany") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Company n = new Company();
        n.setName(name);
        n.setEmail(email);
        if (userService.addCompany(n)) {
            return "Saved";
        } else {
            return "User already register";
        }
    }


    @GetMapping(path = "/auth")
    public @ResponseBody
    String authenticate(@RequestParam String email, @RequestParam String pass) {

        if (userService.authCompany(email, pass)) {
            return "welcome " + email;
        } else {
            return "Wrong Pass";
        }
    }

    @GetMapping(path = "/allCompanies")
    public @ResponseBody
    Iterable<Company> getAllCandidates() {
        // This returns a JSON or XML with the users
        return userService.getAllCompanies();
    }


}
