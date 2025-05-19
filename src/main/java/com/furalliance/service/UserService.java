package com.furalliance.service;

import com.furalliance.config.DbConfig;
import com.furalliance.model.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static Connection dbConn;
    private boolean isConnectionError = false;

    public UserService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            isConnectionError = true;
        }
    }

    // CREATE
    public boolean createUser(UserModel user) {
        if (isConnectionError) return false;

        String sql = "INSERT INTO user (first_name, last_name, dob, gender, email, number, password, imageUrl, username) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setDate(3, Date.valueOf(user.getDob()));
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getEmail());     
            stmt.setString(6, user.getNumber());
            stmt.setString(7, user.getPassword());
            stmt.setString(8, user.getImageUrl());
            stmt.setString(9, user.getUserName());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ (by username)
    public UserModel getUserByUsername(String username) {
        if (isConnectionError) return null;

        String sql = "SELECT * FROM user WHERE username = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new UserModel(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("username"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("gender"),
                    rs.getString("email"),
                    rs.getString("number"),
                    rs.getString("password"),
                    rs.getString("imageUrl")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public boolean updateUser(UserModel user) {
        if (isConnectionError) return false;

        String sql = "UPDATE user SET first_name = ?, last_name = ?, dob = ?, gender = ?, email = ?, number = ?, password = ?, imageUrl = ? WHERE username = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setDate(3, Date.valueOf(user.getDob()));
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getNumber());
            stmt.setString(7, user.getPassword());
            stmt.setString(8, user.getImageUrl());
            stmt.setString(9, user.getUserName());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteUser(String username) {
        if (isConnectionError) return false;

        String sql = "DELETE FROM user WHERE username = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setString(1, username);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // GET ALL USERS
    public List<UserModel> getAllUsers() {
        if (isConnectionError) return null;

        String sql = "SELECT * FROM user";
        List<UserModel> users = new ArrayList<>();

        try (PreparedStatement stmt = dbConn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("username"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("gender"),
                    rs.getString("email"),
                    rs.getString("number"),
                    rs.getString("password"),
                    rs.getString("imageUrl")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
