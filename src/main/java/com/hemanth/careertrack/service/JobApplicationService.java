package com.hemanth.careertrack.service;

import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;

import java.util.List;

public interface JobApplicationService {

    JobApplication create(JobApplication application);

    JobApplication getById(Long id);

    List<JobApplication> getAll(ApplicationStatus status, String companyName);

    JobApplication update(Long id, JobApplication updated);

    void delete(Long id);
}
