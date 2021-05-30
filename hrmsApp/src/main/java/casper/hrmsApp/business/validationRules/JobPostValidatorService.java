package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.JobPost;

public interface JobPostValidatorService {
    public Result isNullCheck(JobPost jobPost);
}
