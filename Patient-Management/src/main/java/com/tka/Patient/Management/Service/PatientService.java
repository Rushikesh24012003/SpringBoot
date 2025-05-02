package com.tka.Patient.Management.Service;

import java.util.ArrayList;

import com.tka.Patient.Management.Dao.PatientDao;
import com.tka.Patient.Management.Entity.Patient;

public class PatientService {
	
	PatientDao dao = new PatientDao();
	
	//Add new Patient
	public void addPatient(Patient patient) {
		if(dao.addPatient(patient) > 0) {
			System.out.println("Patient Added Sucessfully!!");
		}
		else {
			System.out.println("Patient not Added");
		}
	}
	
	//Update patient record
	public void updatePatient(Patient patient) {
		if(dao.updatePatient(patient)>0) {
			System.out.println("Patient Record Updated successfully!!");
		}else {
			System.out.println("Patient record not updated..");
		}
	}
	
	//Delete record by id
		public void deletePatient(int id) {
			if(dao.deletePatient(id)>0) {
				System.out.println("Patient data deleted Successfully!!");
			}else {
				System.out.println("Patient data not deleted..");
			}
		}
	//view all patient 
		public ArrayList<Patient> viewPatients() {
		return dao.viewPatients();
	}
}
