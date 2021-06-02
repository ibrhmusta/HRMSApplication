package casper.hrmsApp.business.abstracts.auth;


import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDtoForAuth;


public interface EmployerAuthService extends UserAuthService<RegisterForEmployerDtoForAuth, Employer> {
}
