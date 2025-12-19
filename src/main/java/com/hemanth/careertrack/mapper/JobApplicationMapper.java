package com.hemanth.careertrack.mapper;

import com.hemanth.careertrack.dto.JobApplicationRequest;
import com.hemanth.careertrack.dto.JobApplicationResponse;
import com.hemanth.careertrack.model.JobApplication;

import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationMapper {

    private JobApplicationMapper() {}

    public static JobApplication toEntity(JobApplicationRequest dto) {
        return JobApplication.builder()
                .companyName(dto.getCompanyName())
                .jobTitle(dto.getJobTitle())
                .jobLocation(dto.getLocation())
                .status(dto.getStatus())
                .applicationSource(dto.getApplicationSource())
                .appliedDate(dto.getAppliedDate())
                .jobLink(dto.getJobLink())
                .expectedCtc(dto.getExpectedCtc())
                .offeredCtc(dto.getOfferedCtc())
                .notes(dto.getNotes())
                .build();
    }

    public static void updateEntity(
            JobApplication entity,
            JobApplicationRequest dto
    ) {
        entity.setCompanyName(dto.getCompanyName());
        entity.setJobTitle(dto.getJobTitle());
        entity.setJobLocation(dto.getLocation());
        entity.setStatus(dto.getStatus());
        entity.setApplicationSource(dto.getApplicationSource());
        entity.setAppliedDate(dto.getAppliedDate());
        entity.setJobLink(dto.getJobLink());
        entity.setExpectedCtc(dto.getExpectedCtc());
        entity.setOfferedCtc(dto.getOfferedCtc());
        entity.setNotes(dto.getNotes());
    }

    public static JobApplicationResponse toResponse(JobApplication entity) {
        return JobApplicationResponse.builder()
                .id(entity.getId())
                .companyName(entity.getCompanyName())
                .jobTitle(entity.getJobTitle())
                .jobLocation(entity.getJobLocation())
                .status(entity.getStatus())
                .applicationSource(entity.getApplicationSource())
                .appliedDate(entity.getAppliedDate())
                .jobLink(entity.getJobLink())
                .expectedCtc(entity.getExpectedCtc())
                .offeredCtc(entity.getOfferedCtc())
                .notes(entity.getNotes())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<JobApplicationResponse> toResponseList(List<JobApplication> list) {
        return list.stream()
                .map(JobApplicationMapper::toResponse)
                .collect(Collectors.toList());
    }
}
