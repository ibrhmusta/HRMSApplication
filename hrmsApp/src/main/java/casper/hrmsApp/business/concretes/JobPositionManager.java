package casper.hrmsApp.business.concretes;


import casper.hrmsApp.business.abstracts.JobPositionService;
import casper.hrmsApp.dataAccess.abstracts.JobPositionDao;
import casper.hrmsApp.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao  jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return this.jobPositionDao.findAll();
    }

    @Override
    public void add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
    }
}
