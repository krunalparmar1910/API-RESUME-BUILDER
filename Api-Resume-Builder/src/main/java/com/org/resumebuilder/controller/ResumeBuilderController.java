package com.org.resumebuilder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.resumebuilder.dto.ResumeBuilderDTO;
import com.org.resumebuilder.service.IResumeBuilderService;

@RestController
@RequestMapping("/api/resumeBuilder")
public class ResumeBuilderController {

	@Autowired
	private IResumeBuilderService resumeBuilderService;

	@GetMapping("/getResumes")
	public List<ResumeBuilderDTO> getAllUsers() {
		return resumeBuilderService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResumeBuilderDTO> getResumeById(@PathVariable Long id) {
		ResumeBuilderDTO resumeOptional = resumeBuilderService.findById(id);
		return new ResponseEntity<>(resumeOptional, HttpStatus.OK);
	}

	@PostMapping("/addResume")
	public ResponseEntity<ResumeBuilderDTO> createResume(@RequestBody ResumeBuilderDTO resumeBuilderDTO) {
		ResumeBuilderDTO savedResume = resumeBuilderService.saveResume(resumeBuilderDTO);
		return ResponseEntity.ok(savedResume);
	}

	@PutMapping("/updateResume/{id}")
	public ResponseEntity<ResumeBuilderDTO> updateResume(@PathVariable long id,
			@RequestBody ResumeBuilderDTO resumeBuilderDTO) {
		ResumeBuilderDTO updatedResume = resumeBuilderService.updateResume(id, resumeBuilderDTO);
		return ResponseEntity.ok(updatedResume);
	}

	@DeleteMapping("/deleteResume/{id}")
	public void deleteResumeBuilder(@PathVariable Long id) {
		resumeBuilderService.deleteResumeBuilder(id);
	}

}
