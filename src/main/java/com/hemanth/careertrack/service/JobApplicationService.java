package com.hemanth.careertrack.service;

import com.hemanth.careertrack.dto.JobApplicationRequest;
import com.hemanth.careertrack.dto.JobApplicationResponse;
import com.hemanth.careertrack.model.ApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobApplicationService {

    JobApplicationResponse create(JobApplicationRequest request);

    List<JobApplicationResponse> getAll(ApplicationStatus status, String companyName);

    JobApplicationResponse getById(Long id);

    JobApplicationResponse update(Long id, JobApplicationRequest request);

    void delete(Long id);

    Page<JobApplicationResponse> getAllPaged(
            ApplicationStatus status,
            String companyName,
            Pageable pageable
    );
}
