package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.LinkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkTypeDao extends JpaRepository<LinkType,Integer> {
}
