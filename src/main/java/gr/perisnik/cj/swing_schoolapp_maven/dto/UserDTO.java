package gr.perisnik.cj.swing_schoolapp_maven.dto;

/**
 * Data Transfer Object for User.
 * This class is used to transfer user data between different layers of the application.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class UserDTO {
    private int id;
    private String username;
    private String password;

    /**
     * Default constructor.
     */
    public UserDTO() {}

    /**
     * Constructs a new UserDTO with the specified ID, username, and password.
     * 
     * @param id the ID of the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public UserDTO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the ID of the user.
     * 
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * 
     * @param id the new ID of the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the username of the user.
     * 
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username the new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     * 
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the user.
     * 
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
