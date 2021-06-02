package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.JobPositionService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(jobPositionService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(jobPositionService.add(jobPosition));
    }
}
