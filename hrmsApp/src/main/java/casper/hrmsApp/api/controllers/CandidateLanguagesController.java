package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CandidateLanguageService;
import casper.hrmsApp.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidatelanguages")
public class CandidateLanguagesController {
    private final CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
        this.candidateLanguageService = candidateLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid CandidateLanguage candidateLanguage){
        return ResponseEntity.ok(this.candidateLanguageService.add(candidateLanguage));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateLanguageService.getAll());
    }
}
