package com.healthcaremanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HealthcareManagementSystem {
	private static List<Patient> patients =new ArrayList<>();
	private static List<Doctor> doctors = new ArrayList<>();
	private static List<Appointment> appointments = new ArrayList<>(); 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
            
        while (isRunning) {
        	System.out.println("Healthcare Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. List Appointments");
            System.out.println("5. List Patients");
            System.out.println("6. List Doctors");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4:
                    listAppointments();
                    break;
                case 5:
                    listPatients();
                    break;
                case 6:
                    listDoctors();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
        
	private static void addPatient(Scanner scanner) {
        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Date of Birth (DD-MM-YYYY): ");
        String dob = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Patient patient = new Patient(name, dob, phoneNo, gender, age);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }
	
	
	private static void addDoctor(Scanner scanner) {
        
		System.out.println("Enter Doctor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization : ");
        String specialization = scanner.nextLine();
        System.out.print("Phone Number: ");   
        String contactInfo = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        scanner.nextLine(); // Consume the newline

        Doctor doctor = new Doctor (name,specialization, contactInfo);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(Scanner scanner) {
        
    	if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Cannot schedule appointment. Insufficient patients or doctors.");
            System.out.println("Please add patients and doctors before scheduling appointments.");
            return;
        }


        System.out.println("Schedule Appointment:");

        
        System.out.println("Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getName());
        }

        System.out.print("Select a patient (enter the number): ");
        int patientIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (patientIndex < 1 || patientIndex > patients.size()) {
            System.out.println("Invalid patient selection.");
            return;
        }

        Patient selectedPatient = patients.get(patientIndex - 1);

        
        System.out.println("Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }

        System.out.print("Select a doctor (enter the number): ");
        int doctorIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (doctorIndex < 1 || doctorIndex > doctors.size()) {
            System.out.println("Invalid doctor selection.");
            return;
        }

        Doctor selectedDoctor = doctors.get(doctorIndex - 1);

        
        System.out.print("Enter appointment date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        
        System.out.print("Enter appointment time: ");
        String time = scanner.nextLine();
        
     // Create a Date object from the provided date (you may want to enhance error handling here)
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-yyyy");
        Date appointmentDate;
        try {
            appointmentDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return;
        }

        // Create an Appointment object and add it to the appointments list
        Appointment appointment = new Appointment(selectedPatient, selectedDoctor, date, time  );
        appointments.add(appointment);

        System.out.println("Appointment scheduled successfully!");
    }
    private static void listAppointments() {
    	if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("List of Scheduled Appointments:");
            for (Appointment appointment : appointments) {
                Patient patient = appointment.getPatient();
                Doctor doctor = appointment.getDoctor();
                String date = appointment.getDate();
                String time = appointment.getTime();
                
                System.out.println("Patient: " + patient.getName());
                System.out.println("Doctor: " + doctor.getName());
                System.out.println("Date: " + date);
				System.out.println("Time: " + time);
                System.out.println("-------------------------");
            }
        }
    }

    private static void listPatients() {
    	if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("List of Patients:");
            for (Patient patient : patients) {
                System.out.println("Name: " + patient.getName());
                System.out.println("Date of Birth: " + patient.getDob());
                System.out.println("Phone Number: " + patient.getPhone_no());
                System.out.println("Gender: " + patient.getGender());
                System.out.println("Age: " + patient.getAge());
                System.out.println("-------------------------");
            }
        }
    }

    private static void listDoctors() {
        // Similar to listPatients, implement code to list all doctors
    	if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialization: " + doctor.getSpecialization());
                System.out.println("Contact Information: " + doctor.getContactInfo());
                System.out.println("-------------------------");
            }
        }
    }
}


