package com.tka.Patient.Management.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Patient.Management.Entity.Patient;
import com.tka.Patient.Management.Service.PatientService;

@RestController
public class PatientController {
	
	PatientService service = new PatientService();
	
	//Add new Patient
	@PostMapping("/addPatient")
	public void addPatient(@RequestBody Patient patient) {
		service.addPatient(patient);
	}
	
	//Update patient record
	@PutMapping("/updatePatient")
	public void updatePatient(@RequestBody Patient patient) {
		service.updatePatient(patient);
	}
	
	//Delete record by id
	@DeleteMapping("/deletePatient/{id}")
	public void deletePatient(@PathVariable int id) {
		service.deletePatient(id);
	}
	
	//view patient by id
	@GetMapping("/viewPatients")
	public ArrayList<Patient> viewPatients() {
		return service.viewPatients();	
	}
}
