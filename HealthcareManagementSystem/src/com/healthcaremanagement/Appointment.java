package com.healthcaremanagement;

import java.text.SimpleDateFormat;

public class Appointment {
	private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    
   //public Appointment(Patient patient, Doctor doctor, String date1, String time) {
     //   this.patient = patient;
       // this.doctor = doctor;
      //  this.date = date1;
       // this.time = time;
    //}

	public Appointment(Patient selectedPatient, Doctor selectedDoctor, String date, String time) {
		this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Appointment{" +
                "patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                ", date=" + dateFormat.format(date) +
                ", time=" + time +
                '}';
	}	

}
