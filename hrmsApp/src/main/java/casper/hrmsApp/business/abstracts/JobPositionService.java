package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
}
