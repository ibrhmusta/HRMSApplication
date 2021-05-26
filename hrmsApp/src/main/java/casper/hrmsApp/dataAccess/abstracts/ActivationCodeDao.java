package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer> {
}
