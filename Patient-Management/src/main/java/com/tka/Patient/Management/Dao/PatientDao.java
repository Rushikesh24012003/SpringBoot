package com.tka.Patient.Management.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tka.Patient.Management.Entity.Patient;


public class PatientDao {
	
	private static final String url = "jdbc:mysql://localhost:3306/Patientmanagement";
	private static final String username = "root";
	private static final String password = "root";
	private PreparedStatement pstmt = null;
	private String sql = null;
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Add new patient
	public int addPatient(Patient patient) {
		int row = 0;
		sql = "insert into patient values(?,?,?,?,?,?)";
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setInt(1, patient.getId());
			pstmt.setString(2, patient.getName());
			pstmt.setString(3, patient.getAddress());
			pstmt.setLong(4, patient.getMobile());
			pstmt.setString(5, patient.getDisease());
			pstmt.setInt(6, patient.getAge());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//Update patient record
	public int updatePatient(Patient patient) {
		int row = 0;
		sql = "update patient set name=? , address=? , mobile=? , disease=? , age=? where id=?";
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, patient.getName());
			pstmt.setString(2, patient.getAddress());
			pstmt.setLong(3, patient.getMobile());
			pstmt.setString(4, patient.getDisease());
			pstmt.setInt(5, patient.getAge());
			pstmt.setInt(6, patient.getId());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	//Delete record by id
	public int deletePatient(int id) {
		int row =0;
		sql = "delete from patient where id=?";
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
		
	}
	
	//view all patients
	public ArrayList<Patient> viewPatients() {
		ArrayList<Patient> alpatients = new ArrayList<Patient>();
		sql = "select * from patient";
		try {
			pstmt = getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id =  rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				Long mobile = rs.getLong(4);
				String disease = rs.getString(5);
				int age = rs.getInt(6);
			    alpatients.add(new Patient(id, name, address, id, disease, age));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alpatients;
	}
}
