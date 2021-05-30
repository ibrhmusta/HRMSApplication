package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Employee;

public interface EmployeeValidatorService {
    public Result isEmployeeNullCheck(Employee employee);
}
