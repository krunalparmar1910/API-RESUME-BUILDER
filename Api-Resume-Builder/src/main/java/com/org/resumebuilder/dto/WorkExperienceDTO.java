package com.org.resumebuilder.dto;

public class WorkExperienceDTO {

	private int id;

	private String designation;

	private String companyName;

	private String comStartDate;

	private String comEndDate;

	private String workLocation;

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
