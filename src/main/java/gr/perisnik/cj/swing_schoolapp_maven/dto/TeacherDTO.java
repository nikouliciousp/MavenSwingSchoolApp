package gr.perisnik.cj.swing_schoolapp_maven.dto;

/**
 * Data Transfer Object for Teacher.
 * This class is used to transfer teacher data between different layers of the application.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class TeacherDTO {
    private int id;
    private String firstname;
    private String lastname;

    /**
     * Default constructor.
     */
    public TeacherDTO() {}

    /**
     * Constructs a new TeacherDTO with the specified ID, firstname, and lastname.
     * 
     * @param id the ID of the teacher
     * @param firstname the firstname of the teacher
     * @param lastname the lastname of the teacher
     */
    public TeacherDTO(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Returns the ID of the teacher.
     * 
     * @return the ID of the teacher
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the teacher.
     * 
     * @param id the new ID of the teacher
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the firstname of the teacher.
     * 
     * @return the firstname of the teacher
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the teacher.
     * 
     * @param firstname the new firstname of the teacher
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the teacher.
     * 
     * @return the lastname of the teacher
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the teacher.
     * 
     * @param lastname the new lastname of the teacher
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns a string representation of the teacher.
     * 
     * @return a string representation of the teacher
     */
    @Override
    public String toString() {
        return "TeacherDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}
