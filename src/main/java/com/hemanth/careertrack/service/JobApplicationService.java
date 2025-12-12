package com.hemanth.careertrack.service;

import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.model.ApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobApplicationService {

    JobApplication create(JobApplication application);

    JobApplication getById(Long id);

    List<JobApplication> getAll(ApplicationStatus status, String companyName); // keeps old list API

    // NEW paged method
    Page<JobApplication> getAllPaged(ApplicationStatus status, String companyName, Pageable pageable);

    JobApplication update(Long id, JobApplication updated);

    void delete(Long id);
}
