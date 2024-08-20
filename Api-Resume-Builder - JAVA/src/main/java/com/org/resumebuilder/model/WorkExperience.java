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
@Table(name = "work_experience")
public class WorkExperience {

	@Id
	@SequenceGenerator(name = "WORK_EXPERIENCE_ID_GENERATOR", sequenceName = "WORK_EXPERIENCE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORK_EXPERIENCE_ID_GENERATOR")
	private int id;

	private String designation;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "com_start_date")
	private String comStartDate;

	@Column(name = "com_end_date")
	private String comEndDate;

	@Column(name = "work_location")
	private String workLocation;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getComStartDate() {
		return comStartDate;
	}

	public void setComStartDate(String comStartDate) {
		this.comStartDate = comStartDate;
	}

	public String getComEndDate() {
		return comEndDate;
	}

	public void setComEndDate(String comEndDate) {
		this.comEndDate = comEndDate;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

}
