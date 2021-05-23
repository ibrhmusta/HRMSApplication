package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.JobPositionService;
import casper.hrmsApp.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobposition")
public class JobPositionController {
    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition){
        jobPositionService.add(jobPosition);
    }
}
