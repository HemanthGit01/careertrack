package com.hemanth.careertrack.controller;

import com.hemanth.careertrack.dto.JobApplicationRequest;
import com.hemanth.careertrack.dto.JobApplicationResponse;
import com.hemanth.careertrack.mapper.JobApplicationMapper;
import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<JobApplicationResponse> create(
            @Valid @RequestBody JobApplicationRequest request) {

        JobApplication toSave = JobApplicationMapper.toEntity(request);
        JobApplication saved = service.create(toSave);
        JobApplicationResponse response = JobApplicationMapper.toResponse(saved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET ALL (with optional filters)
    @GetMapping
    public ResponseEntity<List<JobApplicationResponse>> getAll(
            @RequestParam(required = false) ApplicationStatus status,
            @RequestParam(required = false) String companyName) {

        List<JobApplication> entities = service.getAll(status, companyName);
        List<JobApplicationResponse> responses = JobApplicationMapper.toResponseList(entities);

        return ResponseEntity.ok(responses);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> getById(@PathVariable Long id) {
        JobApplication entity = service.getById(id);
        JobApplicationResponse response = JobApplicationMapper.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody JobApplicationRequest request) {

        JobApplication updatedEntity = JobApplicationMapper.toEntity(request);
        JobApplication saved = service.update(id, updatedEntity);
        JobApplicationResponse response = JobApplicationMapper.toResponse(saved);

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
