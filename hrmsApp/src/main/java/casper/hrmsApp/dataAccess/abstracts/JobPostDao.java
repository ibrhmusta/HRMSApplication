package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost,Integer> {
    List<JobPost> getByIsActivatedTrueOrderByCreatedDateDesc();
    List<JobPost> getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(LocalDateTime startDate, LocalDateTime finishDate);
    List<JobPost> getByEmployer_IdAndIsActivatedTrue(int employerId);
    JobPost getById(int id);
}
