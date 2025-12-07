package com.hemanth.careertrack.controller;

import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.service.JobApplicationService;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
    private final JobApplicationService service;
    public  JobApplicationController(JobApplicationService service){
        this.service = service;
    }
    //CREATE
    @PostMapping
    public ResponseEntity<JobApplication> create (@RequestBody JobApplication application){
        JobApplication saved = service.create(application);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //GET ALL (With optional filters)
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAll(
            @RequestParam(required = false)ApplicationStatus status,
            @RequestParam(required = false) String companyName){
        List<JobApplication> list = service.getAll(status, companyName);
        return ResponseEntity.ok(list);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable Long id){
        JobApplication application = service.getById(id);
        return ResponseEntity.ok(application);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> update(
            @PathVariable Long id,
            @RequestBody JobApplication updated){
        JobApplication updatedApp = service.update(id , updated);
        return  ResponseEntity.ok(updatedApp);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
