package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.CandidateImageService;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.concretes.CandidateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/candidateimages")
public class CandidateImagesController {

    private final CandidateImageService candidateImageService;

    @Autowired
    public CandidateImagesController(CandidateImageService candidateImageService) {
        this.candidateImageService = candidateImageService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId) {
        CandidateImage candidateImage = new CandidateImage();
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        candidateImage.setCandidate(candidate);
        return ResponseEntity.ok(this.candidateImageService.add(candidateImage,file));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateImageService.getAll());
    }
}
