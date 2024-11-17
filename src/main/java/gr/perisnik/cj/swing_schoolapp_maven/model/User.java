package gr.perisnik.cj.swing_schoolapp_maven.model;

/**
 * Represents a user with an ID, username, and password.
 * This class provides methods to get and set these properties.
 * 
 * @author Peris Nik
 * @version 0.1
 */
public class User {
    private int id;
    private String username;
    private String password;
    
    /**
     * Default constructor.
     */
    public User() {}

    /**
     * Constructs a new User with the specified ID, username, and password.
     * 
     * @param id the ID of the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(int id, String username, String password) {
        super();
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
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
