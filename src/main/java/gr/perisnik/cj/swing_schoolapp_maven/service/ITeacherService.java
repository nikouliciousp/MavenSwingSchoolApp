package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.TeacherDTO;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.TeacherNotFoundException;

/**
 * Service interface for managing teacher operations.
 * This interface provides methods to add, update, delete, and retrieve teacher data.
 * 
 * @version 0.1
 * @autor Peris Nik
 */
public interface ITeacherService {

    /**
     * Adds a new teacher.
     * 
     * @param teacher the teacher data transfer object.
     * @return the added teacher.
     * @throws TeacherDAOException if an error occurs while adding the teacher.
     */
    TeacherDTO addTeacher(TeacherDTO teacher) throws TeacherDAOException;
    
    /**
     * Updates an existing teacher.
     * 
     * @param teacher the teacher data transfer object.
     * @return the updated teacher.
     * @throws TeacherDAOException if an error occurs while updating the teacher.
     * @throws TeacherNotFoundException if the teacher not founded.
     */
    TeacherDTO updateTeacher(TeacherDTO teacher) throws TeacherDAOException, TeacherNotFoundException;
    
    /**
     * Deletes a teacher based on the teacher's ID.
     * 
     * @param teacherId the ID of the teacher to be deleted.
     * @throws TeacherDAOException if an error occurs while deleting the teacher.
     * @throws TeacherNotFoundException if the teacher not founded.
     */
    void deleteTeacher(int teacherId) throws TeacherDAOException, TeacherNotFoundException;
    
    /**
     * Retrieves a teacher based on the teacher's ID.
     * 
     * @param teacherId the ID of the teacher to be retrieved.
     * @return the teacher with the specified ID.
     * @throws TeacherDAOException if an error occurs while retrieving the teacher.
     * @throws TeacherNotFoundException if the teacher not founded.
     */
    TeacherDTO getTeacherById(int teacherId) throws TeacherDAOException, TeacherNotFoundException;
    
    /**
     * Retrieves a list of teachers based on the teacher's lastname.
     * 
     * @param lastname the lastname of the teachers to be retrieved
     * @return a list of teachers with the specified lastname.
     * @throws TeacherDAOException if an error occurs while retrieving the teachers.
     * @throws TeacherNotFoundException if the teacher not founded.
     * @throws TeacherNotFoundException if the teacher not founded.
     */
    List<TeacherDTO> getTeacherByLastname(String lastname) throws TeacherDAOException, TeacherNotFoundException;
    
    /**
     * Retrieves a list of all teachers.
     * 
     * @return a list of all teachers.
     * @throws TeacherDAOException if an error occurs while retrieving the teachers.
     */
    List<TeacherDTO> getAllTeachers() throws TeacherDAOException;
}

