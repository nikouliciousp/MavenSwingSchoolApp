package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.ITeacherDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.TeacherDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.TeacherDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.Teacher;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImpl implements ITeacherService {
    
    private ITeacherDAO teacherDAO = new TeacherDAOImpl();
    
    public TeacherServiceImpl(ITeacherDAO teacherDAO) {
        super();
        this.teacherDAO = teacherDAO;
    }

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) throws TeacherDAOException {
        if (teacherDTO == null) {
            return null;
        }
        
        try {
            Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getFirstname(), teacherDTO.getLastname());
            teacher = teacherDAO.addTeacher(teacher);
            return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) throws TeacherDAOException, TeacherNotFoundException {
        if (teacherDTO == null) {
            return null;
        }
        
        try {
            if (teacherDAO.getTeacherById(teacherDTO.getId()) == null) {
                throw new TeacherNotFoundException("Teacher with ID " + teacherDTO.getId() + " not found");
            }
            Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getFirstname(), teacherDTO.getLastname());
            teacher = teacherDAO.updateTeacher(teacher);
            return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public void deleteTeacher(int teacherId) throws TeacherDAOException, TeacherNotFoundException {
        try {
            if (teacherDAO.getTeacherById(teacherId) == null) {
                throw new TeacherNotFoundException("Teacher with ID " + teacherId + " not found");
            }
            teacherDAO.deleteTeacher(teacherId);
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public TeacherDTO getTeacherById(int teacherId) throws TeacherDAOException, TeacherNotFoundException {
        try {
            Teacher teacher = teacherDAO.getTeacherById(teacherId);
            if (teacher == null) {
                throw new TeacherNotFoundException("Teacher with ID " + teacherId + " not found");
            }
            return new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname());
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public List<TeacherDTO> getTeacherByLastname(String lastname) throws TeacherDAOException, TeacherNotFoundException {
        if (lastname == null || lastname.trim().isEmpty()) {
            return getAllTeachers();
        }
        
        try {
            List<Teacher> teachers = teacherDAO.getTeacherByLastname(lastname);
            if (teachers == null || teachers.isEmpty()) {
                throw new TeacherNotFoundException("Teachers with lastname " + lastname + " not found");
            }
            return teachers.stream()
                .map(teacher -> new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname()))
                .collect(Collectors.toList());
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public List<TeacherDTO> getAllTeachers() throws TeacherDAOException {
        try {
            List<Teacher> teachers = teacherDAO.getAllTeachers();
            return teachers.stream()
                .map(teacher -> new TeacherDTO(teacher.getId(), teacher.getFirstname(), teacher.getLastname()))
                .collect(Collectors.toList());
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
