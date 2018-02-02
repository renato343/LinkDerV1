package org.renato.Controllers;

import org.renato.model.pojos.Company;
import org.renato.model.pojos.Frameworks;
import org.renato.model.pojos.Languages;
import org.renato.model.pojos.Projects;
import org.renato.model.pojos.wrapper.CompanyWrapper;
import org.renato.model.pojos.wrapper.ProjectWrapper;
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

    @RequestMapping(method = RequestMethod.POST, path = "addCompany")
    public @ResponseBody
    void addNewUser() {

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

    @RequestMapping(method = RequestMethod.POST, path = "/logout") // Map ONLY GET Requests
    public @ResponseBody
    String logout () {
        return "logged Out";
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




    @GetMapping(path = "/allProjects")
    public @ResponseBody
    Iterable<ProjectWrapper> getAllProjects() {

        // This returns a JSON or XML with the users
        Iterable<Projects> proj = userService.getallProjects();
        List<ProjectWrapper> projectWrapperList = new ArrayList<>();

        proj.forEach(pr -> {

            ProjectWrapper pw = new ProjectWrapper ();

            pw.setProject_id(pr.getProjectId());
            pw.setName(pr.getName());
            pw.setLanguages(userService.getLanguage_Project(pr.getProjectId()));
            pw.setFrameworks(userService.getFrameworks_Project(pr.getProjectId()));

            projectWrapperList.add(pw);

        });
        return projectWrapperList;
    }






    @GetMapping(path = "/id")
    public @ResponseBody
    Company getCompanyById(@RequestParam long id) {
        return userService.getCompanyById(id);
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



}
