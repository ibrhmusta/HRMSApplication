package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.business.abstracts.auth.EmployerAuthService;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager implements EmployerAuthService {
    private AuthValidatorService authValidatorService;
    private EmployerService employerService;

    public EmployerAuthManager(EmployerService employerService,AuthValidatorService authValidatorService) {
        this.authValidatorService = authValidatorService;
        this.employerService = employerService;
    }

    @Override
    public DataResult<String> registerForEmployer(RegisterForEmployerDto registerForEmployerDto) {
        Result result = BusinessEngine.run(authValidatorService.isPasswordConfirmed(registerForEmployerDto.getPassword(),
                registerForEmployerDto.getConfirmPassword()));
        if(result.isSuccess()) {
            Employer employer = new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAdress(),
                    registerForEmployerDto.getPhoneNumber(),registerForEmployerDto.getEmail(),registerForEmployerDto.getPassword());
            employerService.add(employer);
        }
        return new ErrorDataResult<>(null, result.getMessage());
    }
}
