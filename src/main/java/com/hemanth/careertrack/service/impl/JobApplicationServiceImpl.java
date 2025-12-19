package com.hemanth.careertrack.service.impl;

import com.hemanth.careertrack.dto.JobApplicationRequest;
import com.hemanth.careertrack.dto.JobApplicationResponse;
import com.hemanth.careertrack.exception.ResourceNotFoundException;
import com.hemanth.careertrack.mapper.JobApplicationMapper;
import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.model.User;
import com.hemanth.careertrack.repository.JobApplicationRepository;
import com.hemanth.careertrack.repository.UserRepository;
import com.hemanth.careertrack.service.JobApplicationService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobRepo;
    private final UserRepository userRepo;

    public JobApplicationServiceImpl(
            JobApplicationRepository jobRepo,
            UserRepository userRepo
    ) {
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    @Override
    public JobApplicationResponse create(JobApplicationRequest request) {
        User user = getCurrentUser();

        JobApplication entity = JobApplicationMapper.toEntity(request);
        entity.setUser(user);

        return JobApplicationMapper.toResponse(jobRepo.save(entity));
    }

    @Override
    public List<JobApplicationResponse> getAll(
            ApplicationStatus status,
            String companyName
    ) {
        User user = getCurrentUser();

        List<JobApplication> jobs =
                (status != null && companyName != null)
                        ? jobRepo.findByUserAndStatusAndCompanyNameContainingIgnoreCase(
                        user, status, companyName
                )
                        : jobRepo.findByUser(user);

        return JobApplicationMapper.toResponseList(jobs);
    }

    @Override
    public JobApplicationResponse getById(Long id) {
        JobApplication job = jobRepo.findByIdAndUser(id, getCurrentUser())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job application not found")
                );

        return JobApplicationMapper.toResponse(job);
    }

    @Override
    public JobApplicationResponse update(
            Long id,
            JobApplicationRequest request
    ) {
        JobApplication job = jobRepo.findByIdAndUser(id, getCurrentUser())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job application not found")
                );

        JobApplicationMapper.updateEntity(job, request);
        return JobApplicationMapper.toResponse(jobRepo.save(job));
    }

    @Override
    public void delete(Long id) {
        JobApplication job = jobRepo.findByIdAndUser(id, getCurrentUser())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job application not found")
                );

        jobRepo.delete(job);
    }

    @Override
    public Page<JobApplicationResponse> getAllPaged(
            ApplicationStatus status,
            String companyName,
            Pageable pageable
    ) {
        return jobRepo.findByUser(getCurrentUser(), pageable)
                .map(JobApplicationMapper::toResponse);
    }

    private User getCurrentUser() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepo.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );
    }
}
