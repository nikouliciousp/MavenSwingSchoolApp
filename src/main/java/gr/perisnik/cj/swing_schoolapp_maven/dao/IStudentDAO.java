package gr.perisnik.cj.swing_schoolapp_maven.dao;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.model.Student;

/**
 * This interface defines the methods for accessing and manipulating student data.
 * Implementations of this interface should provide the actual logic for interacting
 * with the data source (e.g., database) to perform CRUD operations.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public interface IStudentDAO {
    // Define method signatures for CRUD operations on Student entities

    /**
     * Adds a new student to the data source.
     * 
     * @param student the student to be added
     * @throws StudentDAOException if an error occurs while adding the student
     */
    void addStudent(Student student) throws StudentDAOException;

    /**
     * Updates the details of an existing student in the data source.
     * 
     * @param student the student with updated details
     * @throws StudentDAOException if an error occurs while updating the student
     */
    void updateStudent(Student student) throws StudentDAOException;

    /**
     * Deletes a student from the data source based on the student's ID.
     * 
     * @param studentId the ID of the student to be deleted
     * @throws StudentDAOException if an error occurs while deleting the student
     */
    void deleteStudent(int studentId) throws StudentDAOException;

    /**
     * Retrieves a student from the data source based on the student's ID.
     * 
     * @param studentId the ID of the student to be retrieved
     * @return the student with the specified ID, or null if not found
     * @throws StudentDAOException if an error occurs while retrieving the student
     */
    Student getStudentById(int studentId) throws StudentDAOException;

    /**
     * Retrieves a list of students from the data source based on the student's lastname.
     * 
     * @param lastname the lastname of the students to be retrieved
     * @return a list of students with the specified lastname, or an empty list if none found
     * @throws StudentDAOException if an error occurs while retrieving the students
     */
    List<Student> getStudentByLastname(String lastname) throws StudentDAOException;
    
    /**
     * Retrieves a list of all students from the data source.
     * 
     * @return a list of all students
     * @throws StudentDAOException if an error occurs while retrieving the students
     */
    List<Student> getAllStudents() throws StudentDAOException;
}
