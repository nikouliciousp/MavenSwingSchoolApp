package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.StudentDTO;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.StudentNotFoundException;

/**
 * Service interface for managing student operations.
 * This interface provides methods to add, update, delete, and retrieve student data.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public interface IStudentService {

    /**
     * Adds a new student.
     * 
     * @param student the student data transfer object
     * @return the added student
     * @throws StudentDAOException if an error occurs while adding the student
     */
    StudentDTO addStudent(StudentDTO student) throws StudentDAOException;
    
    /**
     * Updates an existing student.
     * 
     * @param student the student data transfer object
     * @return the updated student
     * @throws StudentDAOException if an error occurs while updating the student
     * @throws StudentNotFoundException if the student is not found
     */
    StudentDTO updateStudent(StudentDTO student) throws StudentDAOException, StudentNotFoundException;
    
    /**
     * Deletes a student based on the student's ID.
     * 
     * @param studentId the ID of the student to be deleted
     * @throws StudentDAOException if an error occurs while deleting the student
     * @throws StudentNotFoundException if the student is not found
     */
    void deleteStudent(int studentId) throws StudentDAOException, StudentNotFoundException;
    
    /**
     * Retrieves a student based on the student's ID.
     * 
     * @param studentId the ID of the student to be retrieved
     * @return the student with the specified ID
     * @throws StudentDAOException if an error occurs while retrieving the student
     * @throws StudentNotFoundException if the student is not found
     */
    StudentDTO getStudentById(int studentId) throws StudentDAOException, StudentNotFoundException;
    
    /**
     * Retrieves a list of students based on the student's lastname.
     * 
     * @param lastname the lastname of the students to be retrieved
     * @return a list of students with the specified lastname
     * @throws StudentDAOException if an error occurs while retrieving the students
     * @throws StudentNotFoundException if the students are not found
     */
    List<StudentDTO> getStudentByLastname(String lastname) throws StudentDAOException, StudentNotFoundException;
    
    /**
     * Retrieves a list of all students.
     * 
     * @return a list of all students
     * @throws StudentDAOException if an error occurs while retrieving the students
     */
    List<StudentDTO> getAllStudents() throws StudentDAOException;
}
