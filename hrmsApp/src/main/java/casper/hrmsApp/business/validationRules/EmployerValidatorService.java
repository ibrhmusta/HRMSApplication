package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Employer;

public interface EmployerValidatorService {
    Result employerNullCheck(Employer employer);
    Result isEmailDomainCheck(Employer employer);
}
