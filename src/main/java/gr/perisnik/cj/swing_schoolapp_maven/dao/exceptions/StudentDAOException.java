package gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions;

/**
 * This class represents a custom exception for handling Student DAO related errors.
 * It extends the Exception class and provides a constructor to specify the error message.
 * 
 * @author Peris Nik
 * @version 0.1
 */
public class StudentDAOException extends Exception {
    private final static long serialVersionUID = 1L;
    
    /**
     * Constructs a new StudentDAOException with the specified detail message.
     * 
     * @param s the detail message
     */
    public StudentDAOException(String s) {
        super(s);
    }
}
