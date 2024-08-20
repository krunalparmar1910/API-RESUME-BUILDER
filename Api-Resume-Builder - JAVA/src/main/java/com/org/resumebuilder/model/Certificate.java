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
@Table(name = "certificate")
public class Certificate {

	@Id
	@SequenceGenerator(name = "CERTIFICATE_ID_GENERATOR", sequenceName = "CERTIFICATE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CERTIFICATE_ID_GENERATOR")
	private int id;

	@Column(name = "certificate_title")
	private String certificateTitle;

	@Column(name = "issuing_org")
	private String issuingOrg;

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

	public String getCertificateTitle() {
		return certificateTitle;
	}

	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}

	public String getIssuingOrg() {
		return issuingOrg;
	}

	public void setIssuingOrg(String issuingOrg) {
		this.issuingOrg = issuingOrg;
	}

	public Long getResumeBuilderId() {
		return resumeBuilderId;
	}

	public void setResumeBuilderId(Long resumeBuilderId) {
		this.resumeBuilderId = resumeBuilderId;
	}

	public ResumeBuilder getResumeBuilder() {
		return resumeBuilder;
	}

	public void setResumeBuilder(ResumeBuilder resumeBuilder) {
		this.resumeBuilder = resumeBuilder;
	}

}
