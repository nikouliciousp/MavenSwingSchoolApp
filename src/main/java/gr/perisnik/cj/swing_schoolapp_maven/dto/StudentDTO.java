package gr.perisnik.cj.swing_schoolapp_maven.dto;

/**
 * Data Transfer Object for Student.
 * This class is used to transfer student data between different layers of the application.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;

    /**
     * Default constructor.
     */
    public StudentDTO() {}

    /**
     * Constructs a new StudentDTO with the specified ID, firstname, and lastname.
     * 
     * @param id the ID of the student
     * @param firstname the firstname of the student
     * @param lastname the lastname of the student
     */
    public StudentDTO(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Returns the ID of the student.
     * 
     * @return the ID of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     * 
     * @param id the new ID of the student
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the firstname of the student.
     * 
     * @return the firstname of the student
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the student.
     * 
     * @param firstname the new firstname of the student
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the student.
     * 
     * @return the lastname of the student
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the student.
     * 
     * @param lastname the new lastname of the student
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns a string representation of the student.
     * 
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "StudentDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}
