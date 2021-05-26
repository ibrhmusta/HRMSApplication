package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.business.validationRules.EmployerValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {
    private EmployerValidatorService employerValidatorService;

    public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) {
        super(userDao);
        this.employerValidatorService = employerValidatorService;
    }

    @Override
    public Result add(Employer employer) {
        Result result= BusinessEngine.run(employerValidatorService.employerNullCheck(employer),
                employerValidatorService.isEmailDomainCheck(employer));
        if(result.isSuccess()){
        return super.add(employer);
        }
        return result;
    }
}
