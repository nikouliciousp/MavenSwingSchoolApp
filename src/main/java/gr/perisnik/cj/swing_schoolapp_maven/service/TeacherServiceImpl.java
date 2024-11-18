package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.ITeacherDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.TeacherDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.TeacherDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.Teacher;

public class TeacherServiceImpl implements ITeacherService {
    
    private ITeacherDAO teacherDAO = new TeacherDAOImpl();
    
    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) throws TeacherDAOException {
        Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getFirstname(), teacherDTO.getLastname());
        teacher = teacherDAO.addTeacher(teacher);
        return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
    }
    
    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) throws TeacherDAOException {
        Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getFirstname(), teacherDTO.getLastname());
        teacher = teacherDAO.updateTeacher(teacher);
        return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
    }
    
    @Override
    public void deleteTeacher(int teacherId) throws TeacherDAOException {
        teacherDAO.deleteTeacher(teacherId);
    }
    
    @Override
    public TeacherDTO getTeacherById(int teacherId) throws TeacherDAOException {
        Teacher teacher = teacherDAO.getTeacherById(teacherId);
        return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
    }
    
    @Override
    public List<TeacherDTO> getTeacherByLastname(String lastname) throws TeacherDAOException {
        List<Teacher> teachers = teacherDAO.getTeacherByLastname(lastname);
        return teachers.stream()
            .map(teacher -> new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname()))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<TeacherDTO> getAllTeachers() throws TeacherDAOException {
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        return teachers.stream()
            .map(teacher -> new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname()))
            .collect(Collectors.toList());
    }
}
