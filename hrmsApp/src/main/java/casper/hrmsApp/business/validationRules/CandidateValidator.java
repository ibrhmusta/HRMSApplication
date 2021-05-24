package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constraints.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.Candidate;

import java.util.Date;


public class CandidateValidator extends UserValidator {
    public Result candidateNullCheck(Candidate candidate) {
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        String tc = candidate.getNationalIdentity();
        Date birth = candidate.getDateOfBirth();


        if (super.userNullCheck(candidate).isSuccess() && (firstName == null || firstName.isBlank()) &&
                (lastName == null || lastName.isBlank()) && (tc == null || tc.isBlank()) && birth == null) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
