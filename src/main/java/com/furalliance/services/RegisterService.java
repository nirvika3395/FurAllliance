package com.furalliance.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.furalliance.config.DbConfig;
import com.furalliance.model.UserModel;

public class RegisterService {

	private Connection dbConn;
	
	public RegisterService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
		
	public Boolean addStudent(UserModel userModel) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String insertQuery = "INSERT INTO user (first_name, last_name, dob, gender, email, number, imageUrl, username, password) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery);
			// Insert student details
			insertStmt.setString(1, userModel.getFirstName());
			insertStmt.setString(2, userModel.getLastName());
			insertStmt.setDate(3, Date.valueOf(userModel.getDob()));
			insertStmt.setString(4, userModel.getGender());
			insertStmt.setString(5, userModel.getEmail());
			insertStmt.setString(6, userModel.getNumber());
			insertStmt.setString(7, userModel.getImageUrl());
			insertStmt.setString(8, userModel.getUserName());
			insertStmt.setString(9, userModel.getPassword());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during student registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
}
}