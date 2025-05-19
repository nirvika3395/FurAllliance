package com.furalliance.service;

import com.furalliance.model.RescueModel;
import com.furalliance.config.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
            stmt.setString(2, request.getContactNumber());
            stmt.setString(1, request.getName());
            stmt.setString(3, request.getTypeOfAnimal());
            stmt.setString(5, request.getDescriptionOfInjury());
            stmt.setString(6, request.getUrgencyLevel().toString());
            stmt.setString(4, request.getLocation());
            
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
    
    public class RescueReportService {
        private static Connection dbConn;
        private boolean isConnectionError = false;

        public RescueReportService() {
            try {
                dbConn = DbConfig.getDbConnection();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                isConnectionError = true;
            }
        }

        public List<RescueModel> getAllReports() {
            if (isConnectionError) {
                System.out.println("Connection Error");
                return null;
            }

            String query = "SELECT * FROM rescue_report";
            List<RescueModel> reports = new ArrayList<>();

            try (PreparedStatement stmt = dbConn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RescueModel report = new RescueModel();
                    report.setContactNumber(rs.getString("contact_number"));
                    report.setName(rs.getString("full_name"));
                    report.setAnimalType(rs.getString("animal_type"));
                    report.setInjuryDescription(rs.getString("injury_description"));
                    report.setUrgencyLevel(rs.getString("urgency_level"));
                    report.setLocation(rs.getString("injury_location"));
                    report.setAdditionalNotes(rs.getString("additional_notes"));

                    reports.add(report);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return reports;
        }

        public boolean createReport(RescueModel report) {
            if (isConnectionError) {
                System.out.println("Connection Error");
                return false;
            }

            String query = "INSERT INTO rescue_report " +
                    "(contact_number, full_name, animal_type, injury_description, urgency_level, injury_location, additional_notes) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
                stmt.setString(1, report.getContactNumber());
                stmt.setString(2, report.getName());
                stmt.setString(3, report.getAnimalType());
                stmt.setString(4, report.getInjuryDescription());
                stmt.setString(5, report.getUrgencyLevel() != null ? report.getUrgencyLevel() : "medium");
                stmt.setString(6, report.getLocation());
                stmt.setString(7, report.getAdditionalNotes());

                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean updateReport(RescueModel report) {
            if (isConnectionError) {
                System.out.println("Connection Error");
                return false;
            }

            String query = "UPDATE rescue_report SET " +
                    "full_name = ?, animal_type = ?, injury_description = ?, urgency_level = ?, " +
                    "injury_location = ?, additional_notes = ? WHERE contact_number = ?";

            try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
                stmt.setString(1, report.getName());
                stmt.setString(2, report.getAnimalType());
                stmt.setString(3, report.getInjuryDescription());
                stmt.setString(4, report.getUrgencyLevel());
                stmt.setString(5, report.getLocation());
                stmt.setString(6, report.getAdditionalNotes());
                stmt.setString(7, report.getContactNumber());

                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean deleteReport(String contactNumber) {
            if (isConnectionError) {
                System.out.println("Connection Error");
                return false;
            }

            String query = "DELETE FROM rescue_report WHERE contact_number = ?";

            try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
                stmt.setString(1, contactNumber);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public RescueModel getReportByContact(String contactNumber) {
            if (isConnectionError) {
                System.out.println("Connection Error");
                return null;
            }

            String query = "SELECT * FROM rescue_report WHERE contact_number = ?";

            try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
                stmt.setString(1, contactNumber);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    RescueModel report = new RescueModel();
                    report.setContactNumber(rs.getString("contact_number"));
                    report.setName(rs.getString("full_name"));
                    report.setAnimalType(rs.getString("animal_type"));
                    report.setInjuryDescription(rs.getString("injury_description"));
                    report.setUrgencyLevel(rs.getString("urgency_level"));
                    report.setInjuryDescription(rs.getString("injury_location"));
                    report.setAdditionalNotes(rs.getString("additional_notes"));
                    return report;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}