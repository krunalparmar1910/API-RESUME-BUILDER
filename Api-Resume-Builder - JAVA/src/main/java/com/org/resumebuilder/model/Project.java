package com.org.resumebuilder.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

	@Id
	@SequenceGenerator(name = "PROJECT_ID_GENERATOR", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_GENERATOR")
	private int id;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "resume_builder_id")
	private Long resumeBuilderId;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_builder_id", updatable = false, insertable = false)
	private ResumeBuilder resumeBuilder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public ResumeBuilder getResumeBuilder() {
		return resumeBuilder;
	}

	public void setResumeBuilder(ResumeBuilder resumeBuilder) {
		this.resumeBuilder = resumeBuilder;
	}

	public Long getResumeBuilderId() {
		return resumeBuilderId;
	}

	public void setResumeBuilderId(Long resumeBuilderId) {
		this.resumeBuilderId = resumeBuilderId;
	}

}
