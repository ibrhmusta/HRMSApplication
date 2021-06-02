package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.EmployeeService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.EmployeeValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {
    private final EmployeeValidatorService employeeValidatorService;

    @Autowired
    public EmployeeManager(UserDao<Employee> userDao, EmployeeValidatorService employeeValidatorService) {
        super(userDao);
        this.employeeValidatorService = employeeValidatorService;
    }

    @Override
    public Result add(Employee employee) {
        Result result = BusinessEngine.run(employeeValidatorService.isEmployeeNullCheck(employee));
        if (!result.isSuccess()) {
            return result;
        }
        employee.setUid(CodeGenerator.generateUuidCode());
        super.add(employee);
        return new SuccessResult(Messages.EmployeeAdded);
    }

}
