package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CvService;
import casper.hrmsApp.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cv")
public class CVController {
    private CvService cvService;

    @Autowired
    public CVController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CvDto cvDto, int candidateId) {
        return ResponseEntity.ok(cvService.add(cvDto,candidateId));
    }
}
