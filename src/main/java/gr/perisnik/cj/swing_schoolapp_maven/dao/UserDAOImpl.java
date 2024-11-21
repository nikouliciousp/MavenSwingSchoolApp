package gr.perisnik.cj.swing_schoolapp_maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.model.User;
import gr.perisnik.cj.swing_schoolapp_maven.service.util.DBUtil;

/**
 * Implementation of the IUserDAO interface for accessing and manipulating user data.
 * This class provides the actual logic for interacting with the data source (e.g., database)
 * to perform CRUD operations on user entities.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class UserDAOImpl implements IUserDAO {

	@Override
	public User addUser(User user) throws UserDAOException {
	    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        if (user.getUsername().equals("") || user.getPassword().equals("")) {
	            return null;
	        }
	        
	        pstmt.setString(1, user.getUsername());
	        pstmt.setString(2, user.getPassword());
	        
	        pstmt.executeUpdate();
	        
	        return user;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	        throw new UserDAOException("Error adding user: " + e.getMessage());
	    }
	}

	@Override
	public User updateUser(User user) throws UserDAOException {
	    String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        if (user.getUsername().equals("") || user.getPassword().equals("")) {
	            return null;
	        }
	        
	        pstmt.setString(1, user.getUsername());
	        pstmt.setString(2, user.getPassword());
	        pstmt.setInt(3, user.getId());
	        
	        pstmt.executeUpdate();
	        
	        return user;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	        throw new UserDAOException("Error updating user: " + e.getMessage());
	    }
	}

    @Override
    public void deleteUser(int userId) throws UserDAOException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new UserDAOException("Error deleting user: " + e.getMessage());
        }
    }

    @Override
    public User getUserById(int userId) throws UserDAOException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new UserDAOException("Error retrieving user by ID: " + e.getMessage());
        }
    }

    @Override
    public User getUserByUsername(String username) throws UserDAOException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new UserDAOException("Error retrieving user by username: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() throws UserDAOException {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new UserDAOException("Error retrieving all users: " + e.getMessage());
        }
        return users;
    }
}
