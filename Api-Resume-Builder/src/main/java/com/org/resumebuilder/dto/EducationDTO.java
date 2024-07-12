package com.org.resumebuilder.dto;

public class EducationDTO {

	private int id;

	private String instituteName;

	private String degree;

	private String degStartDate;

	private String degEndDate;

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

}
