package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
    Optional<T> findByEmail(String email);
}
