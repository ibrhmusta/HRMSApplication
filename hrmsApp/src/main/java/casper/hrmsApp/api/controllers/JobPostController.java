package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.JobPostService;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobpost")
public class JobPostController {

    private final JobPostService jobPostService;

    @Autowired
    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/toggleactive")
    public ResponseEntity<?> toggleActive(@RequestParam int postId) {
        Result result = this.jobPostService.changeActive(postId);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPost jobPost) {
        var result = this.jobPostService.add(jobPost);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getactives")
    public ResponseEntity<?> getAllByActivated() {
        Result result = this.jobPostService.getAllByActivated();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbyday")
    public ResponseEntity<?> getAllByActivatedAndByDay(@RequestParam int day) {
        Result result = this.jobPostService.getAllByActivatedAndByDay(day);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbyemployer")
    public ResponseEntity<?> getAllByActivatedAndByEmployer(@RequestParam int employerId) {
        Result result = this.jobPostService.getAllByActivatedAndByEmployer(employerId);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
