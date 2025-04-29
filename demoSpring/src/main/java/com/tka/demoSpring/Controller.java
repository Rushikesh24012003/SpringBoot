package com.tka.demoSpring;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/getMessage")
	String getMessage() {
		return "Welcome To SpringBoot Application";
	}
	
	@GetMapping("/getStudent")
	  Student getStudent() {
		  Student student = new Student(1 , "Rushikesh", 22);
		  return student; 
	 }
	
	@GetMapping("/getalstu")
	ArrayList<Student> getListOfstudents(){
		ArrayList<Student> alstu = new ArrayList<Student>();
		alstu.add(new Student(101 , "Rushikesh" , 22));
		alstu.add(new Student(102 , "Nishhal" , 23));
		return alstu;
	}
	
	@PostMapping("/addStudent1")
	void addStudent(@RequestBody Student  student){
		System.out.println(student);
	}
	
	@PutMapping("/updateStudent/{id}")
	void updateStudent(@RequestParam int id) {
		
		System.out.println(id + " data Updated");
	}
}
