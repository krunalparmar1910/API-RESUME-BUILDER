package com.org.resumebuilder.dto;

public class CertificateDTO {

	private int id;

	private String certificateTitle;

	private String issuingOrg;

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

}
