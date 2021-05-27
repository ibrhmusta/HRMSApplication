package casper.hrmsApp.api.controllers;


import casper.hrmsApp.business.abstracts.auth.CandidateAuthService;
import casper.hrmsApp.business.abstracts.auth.EmployerAuthService;
import casper.hrmsApp.business.abstracts.auth.VerifyService;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private CandidateAuthService candidateAuthService;
    private EmployerAuthService employerAuthService;
    private VerifyService verifyService;

    @Autowired
    public AuthController(CandidateAuthService candidateAuthService, EmployerAuthService employerAuthService,VerifyService verifyService) {
        this.candidateAuthService = candidateAuthService;
        this.employerAuthService = employerAuthService;
        this.verifyService =verifyService;
    }

    @PostMapping("/candidate/register")
    public Result registerForCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto){
        return candidateAuthService.register(registerForCandidateDto);
    }

    @PostMapping("/employer/register")
    public Result registerForEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto){
        return employerAuthService.register(registerForEmployerDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String activationCode){
        return verifyService.verify(userId,activationCode);
    }
}
