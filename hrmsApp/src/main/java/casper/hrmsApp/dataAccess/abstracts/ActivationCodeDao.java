package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer> {
    Optional<ActivationCode> findByUserUid(String uid);
}
