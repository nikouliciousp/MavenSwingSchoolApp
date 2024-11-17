package gr.perisnik.cj.swing_schoolapp_maven.dao;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.model.User;

/**
 * This interface defines the methods for accessing and manipulating user data.
 * Implementations of this interface should provide the actual logic for interacting
 * with the data source (e.g., database) to perform CRUD operations.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public interface IUserDAO {
    // Define method signatures for CRUD operations on User entities

    /**
     * Adds a new user to the data source.
     * 
     * @param user the user to be added
     * @throws UserDAOException if an error occurs while adding the user
     */
    void addUser(User user) throws UserDAOException;

    /**
     * Updates the details of an existing user in the data source.
     * 
     * @param user the user with updated details
     * @throws UserDAOException if an error occurs while updating the user
     */
    void updateUser(User user) throws UserDAOException;

    /**
     * Deletes a user from the data source based on the user's ID.
     * 
     * @param userId the ID of the user to be deleted
     * @throws UserDAOException if an error occurs while deleting the user
     */
    void deleteUser(int userId) throws UserDAOException;

    /**
     * Retrieves a user from the data source based on the user's ID.
     * 
     * @param userId the ID of the user to be retrieved
     * @return the user with the specified ID, or null if not found
     * @throws UserDAOException if an error occurs while retrieving the user
     */
    User getUserById(int userId) throws UserDAOException;

    /**
     * Retrieves a user from the data source based on the user's username.
     * 
     * @param username the username of the user to be retrieved
     * @return the user with the specified username, or null if not found
     * @throws UserDAOException if an error occurs while retrieving the user
     */
    User getUserByUsername(String username) throws UserDAOException;

    /**
     * Retrieves a list of all users from the data source.
     * 
     * @return a list of all users
     * @throws UserDAOException if an error occurs while retrieving the users
     */
    List<User> getAllUsers() throws UserDAOException;
}
