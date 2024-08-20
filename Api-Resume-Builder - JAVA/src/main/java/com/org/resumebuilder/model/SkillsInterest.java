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
@Table(name = "skills_interest")

public class SkillsInterest {

	@Id
	@SequenceGenerator(name = "SKILLS_INTREST_ID_GENERATOR", sequenceName = "SKILLS_INTREST_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILLS_INTREST_ID_GENERATOR")
	private int id;

	private String skills;

	private String interest;

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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
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
