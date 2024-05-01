package com.healthcaremanagement;

public class Doctor {
	private String name;
    private String specialization;
    private String contactInfo;
    

    public Doctor(String name, String specialization, String contactInfo) {
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
    
    

}
