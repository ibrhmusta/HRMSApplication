package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CandidateExperienceService;
import casper.hrmsApp.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateexperiences")
public class CandidateExperiencesController {

    private CandidateExperienceService candidateExperienceService;

    @Autowired
    public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
        this.candidateExperienceService = candidateExperienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) CandidateExperience candidateExperience){
        return ResponseEntity.ok(this.candidateExperienceService.add(candidateExperience));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateExperienceService.getAll());
    }

    @GetMapping("/getallbycandidateidorderbyleavedate")
    public ResponseEntity<?> getAllOrderByLeaveDate(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateExperienceService.getAllByCandidateIdOrderByLeaveDate(candidateId));
    }

}
