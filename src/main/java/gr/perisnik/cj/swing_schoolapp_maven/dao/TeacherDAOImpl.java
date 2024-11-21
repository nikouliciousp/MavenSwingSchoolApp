package gr.perisnik.cj.swing_schoolapp_maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.model.Teacher;
import gr.perisnik.cj.swing_schoolapp_maven.service.util.DBUtil;

/**
 * Implementation of the ITeacherDAO interface for accessing and manipulating teacher data.
 * This class provides the actual logic for interacting with the data source (e.g., database)
 * to perform CRUD operations on teacher entities.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class TeacherDAOImpl implements ITeacherDAO {

    @Override
    public Teacher addTeacher(Teacher teacher) throws TeacherDAOException {
        String sql = "INSERT INTO teachers (firstname, lastname) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
        	if (teacher.getFirstname().equals("") || teacher.getLastname().equals("")) {
        		return null;
        	}
        	
            pstmt.setString(1, teacher.getFirstname());
            pstmt.setString(2, teacher.getLastname());
            
            pstmt.executeUpdate();
            
            return teacher;
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error adding teacher: " + e.getMessage());
        }
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws TeacherDAOException {
        String sql = "UPDATE teachers SET firstname = ?, lastname = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
        	if (teacher.getFirstname().equals("") || teacher.getLastname().equals("")) {
        		return null;
        	}
        	
            pstmt.setString(1, teacher.getFirstname());
            pstmt.setString(2, teacher.getLastname());
            pstmt.setInt(3, teacher.getId());
            
            pstmt.executeUpdate();
            
            return teacher;
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error updating teacher: " + e.getMessage());
        }
    }

    @Override
    public void deleteTeacher(int teacherId) throws TeacherDAOException {
        String sql = "DELETE FROM teachers WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, teacherId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error deleting teacher: " + e.getMessage());
        }
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws TeacherDAOException {
        String sql = "SELECT * FROM teachers WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, teacherId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Teacher(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error retrieving teacher by ID: " + e.getMessage());
        }
    }

    @Override
    public List<Teacher> getTeacherByLastname(String lastname) throws TeacherDAOException {
        String sql = "SELECT * FROM teachers WHERE lastname LIKE ?";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lastname + '%');
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    teachers.add(new Teacher(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error retrieving teachers by lastname: " + e.getMessage());
        }
        return teachers;
    }

    @Override
    public List<Teacher> getAllTeachers() throws TeacherDAOException {
        String sql = "SELECT * FROM teachers";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                teachers.add(new Teacher(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new TeacherDAOException("Error retrieving all teachers: " + e.getMessage());
        }
        return teachers;
    }
}
