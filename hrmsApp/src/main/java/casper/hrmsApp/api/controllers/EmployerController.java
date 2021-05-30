package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CandidateService;
import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }
}
