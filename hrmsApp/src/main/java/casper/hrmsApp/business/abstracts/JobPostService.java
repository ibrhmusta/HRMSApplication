package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.JobPost;

import java.util.List;

public interface JobPostService {
    public Result add(JobPost jobPost);

    Result changeActive(int postId);

    public DataResult<List<JobPost>> getAll();

    public DataResult<List<JobPost>> getAllByActivated();

    public DataResult<List<JobPost>> getAllByActivatedAndByDay(int day);

    public DataResult<List<JobPost>> getAllByActivatedAndByEmployer(int employerId);
}
