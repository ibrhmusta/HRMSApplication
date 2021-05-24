package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constraints.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.Employer;

import java.util.regex.Pattern;

public class EmployerValidator extends UserValidator {

    public Result employerNullCheck(Employer employer) {
        String companyName = employer.getCompanyName();
        String webAddress = employer.getWebAddress();
        String phoneNumber = employer.getPhoneNumber();

        if (super.userNullCheck(employer).isSuccess() && (companyName == null || companyName.isBlank())
                && (webAddress == null || webAddress.isBlank())&&(phoneNumber==null||phoneNumber.isBlank())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }


    public Result isEmailDomainCheck(Employer employer){
        String email = employer.getEmail();
        String webAddress = employer.getWebAddress();

        String domain = webAddress.split("www.")[1];
        if(domain.equals(email.split("@")[1])){
            return new SuccessResult();
        }
        return new ErrorResult();
    }
}
