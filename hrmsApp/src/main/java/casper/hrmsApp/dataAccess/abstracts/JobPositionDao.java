package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
