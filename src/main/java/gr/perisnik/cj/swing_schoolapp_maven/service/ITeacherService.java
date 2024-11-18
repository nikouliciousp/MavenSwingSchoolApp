package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.TeacherDTO;

public interface ITeacherService {
    
    /**
     * Adds a new teacher.
     * 
     * @param teacher the teacher data transfer object
     * @return the added teacher
     * @throws TeacherDAOException if an error occurs while adding the teacher
     */
    TeacherDTO addTeacher(TeacherDTO teacher) throws TeacherDAOException;
    
    /**
     * Updates an existing teacher.
     * 
     * @param teacher the teacher data transfer object
     * @return the updated teacher
     * @throws TeacherDAOException if an error occurs while updating the teacher
     */
    TeacherDTO updateTeacher(TeacherDTO teacher) throws TeacherDAOException;
    
    void deleteTeacher(int teacherId) throws TeacherDAOException;
    
    TeacherDTO getTeacherById(int teacherId) throws TeacherDAOException;
    
    List<TeacherDTO> getTeacherByLastname(String lastname) throws TeacherDAOException;
    
    List<TeacherDTO> getAllTeachers() throws TeacherDAOException;
}
