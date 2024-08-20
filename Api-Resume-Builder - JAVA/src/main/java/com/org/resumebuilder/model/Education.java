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
@Table(name = "education")
public class Education {

	@Id
	@SequenceGenerator(name = "EDUCATION_ID_GENERATOR", sequenceName = "EDUCATION_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_ID_GENERATOR")
	private int id;

	@Column(name = "institute_name")
	private String instituteName;

	@Column(name = "degree")
	private String degree;

	@Column(name = "deg_start_date")
	private String degStartDate;

	@Column(name = "deg_end_date")
	private String degEndDate;

	@Column(name = "resume_builder_id")
	private Long resumeBuilderId;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_builder_id", insertable = false, updatable = false)
	private ResumeBuilder resumeBuilder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegStartDate() {
		return degStartDate;
	}

	public void setDegStartDate(String degStartDate) {
		this.degStartDate = degStartDate;
	}

	public String getDegEndDate() {
		return degEndDate;
	}

	public void setDegEndDate(String degEndDate) {
		this.degEndDate = degEndDate;
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
