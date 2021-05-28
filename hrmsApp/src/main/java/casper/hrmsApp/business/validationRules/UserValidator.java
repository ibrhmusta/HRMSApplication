package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.abstracts.User;
import com.google.common.base.Strings;

public class UserValidator implements UserValidatorService {

    public Result userNullCheck(User user) {

        if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
