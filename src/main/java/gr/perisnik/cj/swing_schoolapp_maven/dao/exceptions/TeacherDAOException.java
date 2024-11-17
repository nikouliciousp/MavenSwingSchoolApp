package gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions;

/**
 * This class represents a custom exception for handling Teacher DAO related errors.
 * It extends the Exception class and provides a constructor to specify the error message.
 * 
 * @author Peris Nik
 * @version 0.1
 */
public class TeacherDAOException extends Exception {
    private final static long serialVersionUID = 1L;
    
    /**
     * Constructs a new TeacherDAOException with the specified detail message.
     * 
     * @param s the detail message
     */
    public TeacherDAOException(String s) {
        super(s);
    }
}