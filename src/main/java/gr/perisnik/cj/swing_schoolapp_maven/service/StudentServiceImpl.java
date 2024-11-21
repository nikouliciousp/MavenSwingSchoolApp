package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.IStudentDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.StudentDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.StudentDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.Student;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.StudentNotFoundException;

public class StudentServiceImpl implements IStudentService {
    
    private IStudentDAO studentDAO = new StudentDAOImpl();
    
    public StudentServiceImpl(IStudentDAO studentDAO) {
        super();
        this.studentDAO = studentDAO;
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) throws StudentDAOException {
        if (studentDTO == null) {
            return null;
        }
        
        try {
            Student student = new Student(studentDTO.getId(), studentDTO.getFirstname(), studentDTO.getLastname());
            student = studentDAO.addStudent(student);
            return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws StudentDAOException, StudentNotFoundException {
        if (studentDTO == null) {
            return null;
        }
        
        try {
            if (studentDAO.getStudentById(studentDTO.getId()) == null) {
                throw new StudentNotFoundException("Student with ID " + studentDTO.getId() + " not found");
            }
            Student student = new Student(studentDTO.getId(), studentDTO.getFirstname(), studentDTO.getLastname());
            student = studentDAO.updateStudent(student);
            return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public void deleteStudent(int studentId) throws StudentDAOException, StudentNotFoundException {
        try {
            if (studentDAO.getStudentById(studentId) == null) {
                throw new StudentNotFoundException("Student with ID " + studentId + " not found");
            }
            studentDAO.deleteStudent(studentId);
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public StudentDTO getStudentById(int studentId) throws StudentDAOException, StudentNotFoundException {
        try {
            Student student = studentDAO.getStudentById(studentId);
            if (student == null) {
                throw new StudentNotFoundException("Student with ID " + studentId + " not found");
            }
            return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public List<StudentDTO> getStudentByLastname(String lastname) throws StudentDAOException, StudentNotFoundException {
        if (lastname == null || lastname.trim().isEmpty()) {
            return getAllStudents();
        }
        
        try {
            List<Student> students = studentDAO.getStudentByLastname(lastname);
            if (students == null || students.isEmpty()) {
                throw new StudentNotFoundException("Students with lastname " + lastname + " not found");
            }
            return students.stream()
                .map(student -> new StudentDTO(student.getId(), student.getFirstname(), student.getLastname()))
                .collect(Collectors.toList());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public List<StudentDTO> getAllStudents() throws StudentDAOException {
        try {
            List<Student> students = studentDAO.getAllStudents();
            return students.stream()
                .map(student -> new StudentDTO(student.getId(), student.getFirstname(), student.getLastname()))
                .collect(Collectors.toList());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
