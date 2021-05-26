package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.entities.abstracts.User;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;


public interface EmployerAuthService {
    DataResult<String> registerForEmployer(RegisterForEmployerDto registerForEmployerDto);

}
