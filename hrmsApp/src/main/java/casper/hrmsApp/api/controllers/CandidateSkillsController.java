package casper.hrmsApp.api.controllers;


import casper.hrmsApp.business.abstracts.CandidateSkillService;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateskills")
public class CandidateSkillsController {

    private CandidateSkillService candidateSkillService;

    @Autowired
    public CandidateSkillsController(CandidateSkillService candidateSkillService) {
        this.candidateSkillService = candidateSkillService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CandidateSkill candidateSkill){
        return ResponseEntity.ok(this.candidateSkillService.add(candidateSkill));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateSkillService.getAll());
    }
}
