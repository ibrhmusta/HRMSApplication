package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.abstracts.User;

public class UserValidator implements UserValidatorService {

    public Result userNullCheck(User user) {
        if ((user.getEmail() == null || user.getEmail().isBlank()) && (user.getPassword() == null || user.getPassword().isBlank())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
