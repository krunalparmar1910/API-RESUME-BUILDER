package com.org.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import com.org.resumebuilder.dto.ResumeBuilderDTO;
import com.org.resumebuilder.service.IResumeBuilderService;
import com.org.resumebuilder.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/resumeBuilder")
public class ResumeBuilderController {

	@Autowired
	private IResumeBuilderService iResumeBuilderService;

	@GetMapping("/getResumes")
	public ResponseEntity<List<ResumeBuilderDTO>> getAllResumes() {
		List<ResumeBuilderDTO> resumes = iResumeBuilderService.getAllUsers();
		return ResponseEntity.ok(resumes);
	}

	@GetMapping("/resumeById/{id}")
	public ResponseEntity<ResumeBuilderDTO> getResumeById(@PathVariable Long id) {
		try {
			ResumeBuilderDTO resume = iResumeBuilderService.findById(id);
			return ResponseEntity.ok(resume);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/addResume")
	public ResponseEntity<ResumeBuilderDTO> createResume(@RequestBody ResumeBuilderDTO resumeBuilderDTO) {
		try {
			ResumeBuilderDTO savedResume = iResumeBuilderService.saveResume(resumeBuilderDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedResume);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/updateResume/{id}")
	public ResponseEntity<ResumeBuilderDTO> updateResume(@PathVariable long id,
			@RequestBody ResumeBuilderDTO resumeBuilderDTO) {
		try {
			ResumeBuilderDTO updatedResume = iResumeBuilderService.updateResume(id, resumeBuilderDTO);
			return ResponseEntity.ok(updatedResume);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/deleteResume/{id}")
	public ResponseEntity<String> deleteResume(@PathVariable Long id) {
		try {
			iResumeBuilderService.deleteResumeBuilder(id);
			return ResponseEntity.status(HttpStatus.OK).body("Resume deleted successfully.");
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
    }
}
