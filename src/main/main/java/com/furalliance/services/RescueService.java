package com.furalliance.services;

import com.furalliance.model.RescueModel;
import com.furalliance.config.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class RescueService {
    private Connection dbConn;

    public RescueService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public boolean addRescueRequest(RescueModel request) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return false;
        }

        String insertQuery = "INSERT INTO rescue (full_name, contact_number, animal_type, " +
                           "injury_location, injury_description, urgency_level, additional_notes) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            // Required fields
            stmt.setString(1, request.getContactNumber());
            stmt.setString(2, request.getName());
            stmt.setString(3, request.getTypeOfAnimal());
            stmt.setString(4, request.getDescriptionOfInjury());
            stmt.setString(5, request.getUrgencyLevel());
            stmt.setString(6, request.getLocation());
            
            // Optional field (handle null)
            String notes = request.getAdditionalNotes();
            if (notes == null || notes.trim().isEmpty()) {
                stmt.setNull(7, Types.VARCHAR);
            } else {
                stmt.setString(7, notes);
            }
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error while inserting rescue request: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Add this method to properly close connection when service is no longer needed
    public void close() {
        if (dbConn != null) {
            try {
                dbConn.close();
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}