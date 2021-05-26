package casper.hrmsApp.business.abstracts.auth;


import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;




public interface EmployerAuthService {
    Result register(RegisterForEmployerDto registerForEmployerDto);
}
