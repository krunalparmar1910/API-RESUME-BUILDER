package com.org.resumebuilder.service;

import java.util.List;

import com.org.resumebuilder.dto.ResumeBuilderDTO;

public interface IResumeBuilderService {

	// get list of resume data
	List<ResumeBuilderDTO> getAllUsers();
//	List<ResumeBuilderDTO> getAllResumes();

	// get resume by id
	ResumeBuilderDTO findById(Long id);

	// Save Resume Builder Data.
	ResumeBuilderDTO saveResume(ResumeBuilderDTO resumeBuilderDTO);

	// update Resume Builder Data
	ResumeBuilderDTO updateResume(long id, ResumeBuilderDTO resumeBuilderDTO);

	// delete by id resume builder data
	void deleteResumeBuilder(Long id);


}