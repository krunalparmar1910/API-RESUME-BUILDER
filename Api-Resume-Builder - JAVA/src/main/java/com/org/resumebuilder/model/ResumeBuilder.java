package com.org.resumebuilder.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resume_builder")
public class ResumeBuilder {

	@Id
	@SequenceGenerator(name = "RESUME_BUILDER_ID_GENERATOR", sequenceName = "RESUME_BUILDER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESUME_BUILDER_ID_GENERATOR")
	private Long id;

	private String name;

	private String email;

	private String phone;

	private String address;

	@Column(name = "repo_url")
	private String repoUrl;

	@Column(name = "linkdin_url")
	private String linkdinUrl;

	@Column(name = "profile_summary")
	private String profileSummary;

	@OneToMany(mappedBy = "resumeBuilder")
	private List<Certificate> certificate;

	@OneToMany(mappedBy = "resumeBuilder")
	private List<Education> education;

	@OneToMany(mappedBy = "resumeBuilder")
	private List<Project> project;

	@OneToMany(mappedBy = "resumeBuilder")
	private List<SkillsInterest> skillsInterest;

	@OneToMany(mappedBy = "resumeBuilder")
	private List<WorkExperience> workExperience;

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

	public List<Certificate> getCertificate() {
		return certificate;
	}

	public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<SkillsInterest> getSkillsInterest() {
		return skillsInterest;
	}

	public void setSkillsInterest(List<SkillsInterest> skillsInterest) {
		this.skillsInterest = skillsInterest;
	}

	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}

}
