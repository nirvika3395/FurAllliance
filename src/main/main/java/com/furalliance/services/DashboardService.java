package com.furalliance.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.apache.catalina.User;

import com.furalliance.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {
    private DataSource dataSource;

    public DashboardService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DashboardService() {
		// TODO Auto-generated constructor stub
	}

	public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, user_name, dob, gender, email, number, image_path, is_admin, is_active FROM users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUserName(rs.getString("user_name"));
                user.setDob(rs.getDate("dob").toLocalDate());
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
                user.setNumber(rs.getString("number"));
                user.setImageUrl(rs.getString("image_path"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setActive(rs.getBoolean("is_active"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public UserModel getSpecificUserInfo(String firstNameParam) {
        String query = "SELECT id, first_name, last_name, user_name, dob, gender, email, number, image_path, is_admin, is_active FROM users WHERE first_name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, firstNameParam);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setUserName(rs.getString("user_name"));
                    user.setDob(rs.getDate("dob").toLocalDate());
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setNumber(rs.getString("number"));
                    user.setImageUrl(rs.getString("image_path"));
                    user.setAdmin(rs.getBoolean("is_admin"));
                    user.setActive(rs.getBoolean("is_active"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserModel> getRecentUsers() {
        List<UserModel> users = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, user_name, dob, gender, email, number, image_path, is_admin, is_active FROM users ORDER BY id DESC LIMIT 5";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUserName(rs.getString("user_name"));
                user.setDob(rs.getDate("dob").toLocalDate());
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
                user.setNumber(rs.getString("number"));
                user.setImageUrl(rs.getString("image_path"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setActive(rs.getBoolean("is_active"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(UserModel user) {
        String query = "UPDATE users SET first_name = ?, last_name = ?, dob = ?, gender = ?, email = ?, number = ?, image_path = ?, is_admin = ?, is_active = ? WHERE user_name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(user.getDob()));
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getNumber());
            stmt.setString(7, user.getImageUrl());
            stmt.setBoolean(8, user.isAdmin());
            stmt.setBoolean(9, user.isActive());
            stmt.setString(10, user.getUserName());
            int updated = stmt.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE user_name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            return deleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int countTotalUsers() {
        String query = "SELECT COUNT(*) AS total FROM users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

	public User selectUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertUser(UserModel newUser) {
		// TODO Auto-generated method stub
		
	}

	public UserModel getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
