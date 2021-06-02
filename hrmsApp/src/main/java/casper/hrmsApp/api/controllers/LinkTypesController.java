package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.LinkTypeService;

import casper.hrmsApp.entities.concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/linktypes")
public class LinkTypesController {

    private final LinkTypeService linkTypeService;

    @Autowired
    public LinkTypesController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LinkType linkType){
        return ResponseEntity.ok(this.linkTypeService.add(linkType));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.linkTypeService.getAll());
    }
}
