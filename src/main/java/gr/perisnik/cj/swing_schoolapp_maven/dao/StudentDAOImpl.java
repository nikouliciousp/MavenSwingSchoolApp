package gr.perisnik.cj.swing_schoolapp_maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.model.Student;
import gr.perisnik.cj.swing_schoolapp_maven.service.util.DBUtil;

/**
 * Implementation of the IStudentDAO interface for accessing and manipulating student data.
 * This class provides the actual logic for interacting with the data source (e.g., database)
 * to perform CRUD operations on student entities.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class StudentDAOImpl implements IStudentDAO {

	@Override
	public Student addStudent(Student student) throws StudentDAOException {
	    String sql = "INSERT INTO students (firstname, lastname) VALUES (?, ?)";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        if (student.getFirstname().equals("") || student.getLastname().equals("")) {
	            return null;
	        }
	        
	        pstmt.setString(1, student.getFirstname());
	        pstmt.setString(2, student.getLastname());
	        
	        pstmt.executeUpdate();
	        
	        return student;
	    } catch (SQLException e) {
	        throw new StudentDAOException("Error adding student: " + e.getMessage());
	    }
	}

	@Override
	public Student updateStudent(Student student) throws StudentDAOException {
	    String sql = "UPDATE students SET firstname = ?, lastname = ? WHERE id = ?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        if (student.getFirstname().equals("") || student.getLastname().equals("")) {
	            return null;
	        }
	        
	        pstmt.setString(1, student.getFirstname());
	        pstmt.setString(2, student.getLastname());
	        pstmt.setInt(3, student.getId());
	        
	        pstmt.executeUpdate();
	        
	        return student;
	    } catch (SQLException e) {
	        throw new StudentDAOException("Error updating student: " + e.getMessage());
	    }
	}
	
    @Override
    public void deleteStudent(int studentId) throws StudentDAOException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new StudentDAOException("Error deleting student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int studentId) throws StudentDAOException {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new StudentDAOException("Error retrieving student by ID: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getStudentByLastname(String lastname) throws StudentDAOException {
        String sql = "SELECT * FROM students WHERE lastname = ?";
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lastname);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            throw new StudentDAOException("Error retrieving students by lastname: " + e.getMessage());
        }
        return students;
    }

    @Override
    public List<Student> getAllStudents() throws StudentDAOException {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
            }
        } catch (SQLException e) {
            throw new StudentDAOException("Error retrieving all students: " + e.getMessage());
        }
        return students;
    }
}
