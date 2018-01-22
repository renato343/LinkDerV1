package org.renato.Controllers;

import org.renato.model.pojos.Company;
import org.renato.model.pojos.wrapper.CompanyWrapper;
import org.renato.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @RequestMapping(method = RequestMethod.POST, path = "/auth")
    public @ResponseBody
    ResponseEntity<Company>authenticate(@RequestBody Company user) {

        Company company = new Company();

        if (userService.getCompanyByEmail(user.getEmail()) == null) {
            return new ResponseEntity<Company>(company, HttpStatus.NOT_FOUND);
        }

        if(userService.authCompany(user.getEmail(), user.getPassword())){

            company = userService.getCompanyByEmail(user.getEmail());
            return new ResponseEntity<Company>(company,HttpStatus.OK);

        }else {
            return new ResponseEntity<Company>(company,HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/allCompanies")
    public @ResponseBody
    Iterable<CompanyWrapper> getAllCompanies() {

        // This returns a JSON or XML with the users
        Iterable<Company> companies = userService.getAllCompanies();
        List<CompanyWrapper> companyWrapperList = new ArrayList<>();

        companies.forEach(company -> {
            CompanyWrapper cw = new CompanyWrapper();

            cw.setCompany_id(company.getCompany_id());
            cw.setEmail(company.getEmail());
            cw.setMotto(company.getMotto());
            cw.setName(company.getName());
            cw.setPassword(company.getPassword());
            cw.setProjectsList(userService.getProjectsByCompany(company.getCompany_id()));

            companyWrapperList.add(cw);

        });


        return companyWrapperList;
    }


}
