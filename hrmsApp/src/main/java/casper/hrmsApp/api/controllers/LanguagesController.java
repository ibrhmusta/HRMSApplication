package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.LanguageService;
import casper.hrmsApp.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Language language){
        return ResponseEntity.ok(this.languageService.add(language));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.languageService.getAll());
    }

}
