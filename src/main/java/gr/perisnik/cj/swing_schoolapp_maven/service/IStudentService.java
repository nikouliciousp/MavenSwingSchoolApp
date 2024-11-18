package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.StudentDTO;

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
     */
    StudentDTO updateStudent(StudentDTO student) throws StudentDAOException;
    
    void deleteStudent(int studentId) throws StudentDAOException;
    
    StudentDTO getStudentById(int studentId) throws StudentDAOException;
    
    List<StudentDTO> getStudentByLastname(String lastname) throws StudentDAOException;
    
    List<StudentDTO> getAllStudents() throws StudentDAOException;
}
