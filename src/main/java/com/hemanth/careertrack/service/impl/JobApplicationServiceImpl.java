package com.hemanth.careertrack.service.impl;

import com.hemanth.careertrack.exception.ResourceNotFoundException;
import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.repository.JobApplicationRepository;
import com.hemanth.careertrack.service.JobApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationServiceImpl(JobApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobApplication create(JobApplication application) {
        return repository.save(application);
    }

    @Override
    public JobApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("JobApplication not found with id: " + id));
    }

    @Override
    public List<JobApplication> getAll(ApplicationStatus status, String companyName) {
        if (status != null) {
            return repository.findByStatus(status);
        }
        if (companyName != null && !companyName.isBlank()) {
            return repository.findByCompanyNameContainingIgnoreCase(companyName);
        }
        return repository.findAll();
    }

    @Override
    public JobApplication update(Long id, JobApplication updated) {
        JobApplication existing = getById(id);

        existing.setCompanyName(updated.getCompanyName());
        existing.setJobTitle(updated.getJobTitle());
        existing.setJobLocation(updated.getJobLocation());
        existing.setStatus(updated.getStatus());
        existing.setApplicationSource(updated.getApplicationSource());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setJobLink(updated.getJobLink());
        existing.setExpectedCtc(updated.getExpectedCtc());
        existing.setOfferedCtc(updated.getOfferedCtc());
        existing.setNotes(updated.getNotes());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        JobApplication existing = getById(id);
        repository.delete(existing);
    }
}
