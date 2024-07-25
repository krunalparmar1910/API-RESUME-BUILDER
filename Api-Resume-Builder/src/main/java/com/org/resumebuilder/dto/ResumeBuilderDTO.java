package com.org.resumebuilder.dto;

import java.util.List;

public class ResumeBuilderDTO {

	private Long id;

	private String name;

	private String email;

	private String phone;

	private String address;

	private String repoUrl;

	private String linkdinUrl;

	private String profileSummary;

	private List<EducationDTO> educationDTO;

	private List<CertificateDTO> certificateDTO;

	private List<ProjectDTO> projectDTO;

	private List<SkillsInterestDTO> SkillsInterestDTO;

	private List<WorkExperienceDTO> workExperienceDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public String getLinkdinUrl() {
		return linkdinUrl;
	}

	public void setLinkdinUrl(String linkdinUrl) {
		this.linkdinUrl = linkdinUrl;
	}

	public String getProfileSummary() {
		return profileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}

	public List<EducationDTO> getEducationDTO() {
		return educationDTO;
	}

	public void setEducationDTO(List<EducationDTO> educationDTO) {
		this.educationDTO = educationDTO;
	}

	public List<CertificateDTO> getCertificateDTO() {
		return certificateDTO;
	}

	public void setCertificateDTO(List<CertificateDTO> certificateDTO) {
		this.certificateDTO = certificateDTO;
	}

	public List<ProjectDTO> getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(List<ProjectDTO> projectDTO) {
		this.projectDTO = projectDTO;
	}

	public List<SkillsInterestDTO> getSkillsInterestDTO() {
		return SkillsInterestDTO;
	}

	public void setSkillsInterestDTO(List<SkillsInterestDTO> SkillsInterestDTO) {
		this.SkillsInterestDTO = SkillsInterestDTO;
	}

	public List<WorkExperienceDTO> getWorkExperienceDTO() {
		return workExperienceDTO;
	}

	public void setWorkExperienceDTO(List<WorkExperienceDTO> workExperienceDTO) {
		this.workExperienceDTO = workExperienceDTO;
	}

}
