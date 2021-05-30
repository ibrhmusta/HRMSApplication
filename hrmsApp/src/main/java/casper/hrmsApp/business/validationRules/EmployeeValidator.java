package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.Employee;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator extends UserValidator implements EmployeeValidatorService{
    @Override
    public Result isEmployeeNullCheck(Employee employee) {
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        if(!super.userNullCheck(employee).isSuccess()|| Strings.isNullOrEmpty(firstName)||Strings.isNullOrEmpty(lastName)){
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
