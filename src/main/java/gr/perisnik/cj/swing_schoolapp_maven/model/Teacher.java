package gr.perisnik.cj.swing_schoolapp_maven.model;

/**
 * Represents a teacher with an ID, firstname, and lastname.
 * This class provides methods to get and set these properties.
 * 
 * A {@link Teacher} JavaBean Class.
 * 
 * @author Peris Nik
 * @version 0.1
 */
public class Teacher {
    private int id;
    private String firstname;
    private String lastname;
    
    /**
     * Default constructor.
     */
    public Teacher() {}

    /**
     * Constructs a new Teacher with the specified ID, firstname, and lastname.
     * 
     * @param id the ID of the teacher
     * @param firstname the firstname of the teacher
     * @param lastname the lastname of the teacher
     */
    public Teacher(int id, String firstname, String lastname) {
        super();
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
        return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}