package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.JobPost;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class JobPostValidator implements JobPostValidatorService {
    @Override
    public Result isNullCheck(JobPost jobPost) {
        String description = jobPost.getDescription();
        if (Strings.isNullOrEmpty(description)) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
