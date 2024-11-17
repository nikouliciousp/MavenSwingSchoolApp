package gr.perisnik.cj.swing_schoolapp_maven.model;

/**
 * Represents a student with an ID, firstname, and lastname.
 * This class provides methods to get and set these properties.
 * 
 * @author Peris Nik
 * @version 0.1
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    
    /**
     * Default constructor.
     */
    public Student() {}

    /**
     * Constructs a new Student with the specified ID, firstname, and lastname.
     * 
     * @param id the ID of the student
     * @param firstname the firstname of the student
     * @param lastname the lastname of the student
     */
    public Student(int id, String firstname, String lastname) {
        super();
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
        return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}