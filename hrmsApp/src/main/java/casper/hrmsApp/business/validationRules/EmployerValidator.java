package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.Employer;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;



@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{

    public Result employerNullCheck(Employer employer) {
        String companyName = employer.getCompanyName();
        String webAddress = employer.getWebAddress();
        String phoneNumber = employer.getPhoneNumber();

        if (!super.userNullCheck(employer).isSuccess() || Strings.isNullOrEmpty(companyName)
                || Strings.isNullOrEmpty(webAddress)||Strings.isNullOrEmpty(phoneNumber)) {
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
        return new ErrorResult("Domain geçersiz");
    }
}
