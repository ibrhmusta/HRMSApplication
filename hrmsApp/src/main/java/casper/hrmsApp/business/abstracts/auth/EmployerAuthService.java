package casper.hrmsApp.business.abstracts.auth;


import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;


public interface EmployerAuthService extends UserAuthService<RegisterForEmployerDto, Employer> {
}
