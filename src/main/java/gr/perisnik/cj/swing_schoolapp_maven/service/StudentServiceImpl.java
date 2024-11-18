package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.IStudentDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.StudentDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.StudentDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.Student;

public class StudentServiceImpl implements IStudentService {
    
    private IStudentDAO studentDAO = new StudentDAOImpl();
    
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) throws StudentDAOException {
        Student student = new Student(studentDTO.getId(), studentDTO.getFirstname(), studentDTO.getLastname());
        student = studentDAO.addStudent(student);
        return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
    }
    
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws StudentDAOException {
        Student student = new Student(studentDTO.getId(), studentDTO.getFirstname(), studentDTO.getLastname());
        student = studentDAO.updateStudent(student);
        return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
    }
    
    @Override
    public void deleteStudent(int studentId) throws StudentDAOException {
        studentDAO.deleteStudent(studentId);
    }
    
    @Override
    public StudentDTO getStudentById(int studentId) throws StudentDAOException {
        Student student = studentDAO.getStudentById(studentId);
        return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname());
    }
    
    @Override
    public List<StudentDTO> getStudentByLastname(String lastname) throws StudentDAOException {
        List<Student> students = studentDAO.getStudentByLastname(lastname);
        return students.stream()
            .map(student -> new StudentDTO(student.getId(), student.getFirstname(), student.getLastname()))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<StudentDTO> getAllStudents() throws StudentDAOException {
        List<Student> students = studentDAO.getAllStudents();
        return students.stream()
            .map(student -> new StudentDTO(student.getId(), student.getFirstname(), student.getLastname()))
            .collect(Collectors.toList());
    }
}
