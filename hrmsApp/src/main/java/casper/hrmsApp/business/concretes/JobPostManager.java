package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.JobPostService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.JobPostValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.dataAccess.abstracts.JobPostDao;
import casper.hrmsApp.entities.concretes.JobPost;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobPostManager implements JobPostService {
    private final JobPostDao jobPostDao;
    private final JobPostValidatorService jobPostValidatorService;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao, JobPostValidatorService jobPostValidatorService) {
        this.jobPostDao = jobPostDao;
        this.jobPostValidatorService = jobPostValidatorService;
    }

    @Override
    public Result add(JobPost jobPost) {
        Result result = BusinessEngine.run(jobPostValidatorService.isNullCheck(jobPost));
        if (!result.isSuccess()) {
            return result;
        }
        jobPost.setUid(CodeGenerator.generateUuidCode());
        jobPostDao.save(jobPost);
        return new SuccessResult(Messages.JobPostAdded);
    }

    @Override
    public Result changeActive(int postId) {
        JobPost jobPost = this.jobPostDao.getById(postId);
        Result result = BusinessEngine.run(checkJobPostIsExists(jobPost));
        if (!result.isSuccess()) {
            return result;
        }
        JobPost updatePost = jobPost;
        updatePost.setActivated(!updatePost.isActivated());
        this.jobPostDao.save(updatePost);
        return new SuccessResult(Messages.JobPostUpdated);
    }

    @Override
    public DataResult<List<JobPost>> getAll() {
        return new SuccessDataResult<>(jobPostDao.findAll());
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivated() {
        return new SuccessDataResult<>(jobPostDao.getByIsActivatedTrueOrderByCreatedDateDesc());
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivatedAndByDay(int day) {
        LocalDateTime finishDate = LocalDateTime.now().minusDays(day);
        return new SuccessDataResult<>(jobPostDao.getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(finishDate, LocalDateTime.now()));
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivatedAndByEmployer(int employerId) {
        return new SuccessDataResult<>(jobPostDao.getByEmployer_IdAndIsActivatedTrue(employerId));
    }

    private Result checkJobPostIsExists(JobPost jobPost) {
        if (jobPost == null) {
            return new ErrorResult("İş ilanı mevcut değil");
        }
        return new SuccessResult();
    }
}
