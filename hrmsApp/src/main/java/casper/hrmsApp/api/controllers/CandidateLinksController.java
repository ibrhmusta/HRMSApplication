package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CandidateLinkService;
import casper.hrmsApp.entities.concretes.CandidateLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidatelinks")
public class CandidateLinksController {

    private final CandidateLinkService candidateLinkService;

    @Autowired
    public CandidateLinksController(CandidateLinkService candidateLinkService) {
        this.candidateLinkService = candidateLinkService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CandidateLink candidateLink){
        return ResponseEntity.ok(this.candidateLinkService.add(candidateLink));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateLinkService.getAll());
    }
}
