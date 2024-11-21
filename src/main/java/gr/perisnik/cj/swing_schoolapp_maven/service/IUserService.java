package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.UserNotFoundException;

/**
 * Service interface for managing user operations.
 * This interface provides methods to add, update, delete, and retrieve user data.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public interface IUserService {
    
    /**
     * Adds a new user.
     * 
     * @param user the user data transfer object
     * @return the added user
     * @throws UserDAOException if an error occurs while adding the user
     */
    UserDTO addUser(UserDTO user) throws UserDAOException;
    
    /**
     * Updates an existing user.
     * 
     * @param user the user data transfer object
     * @return the updated user
     * @throws UserDAOException if an error occurs while updating the user
     * @throws UserNotFoundException if the user is not found
     */
    UserDTO updateUser(UserDTO user) throws UserDAOException, UserNotFoundException;
    
    /**
     * Deletes a user based on the user's ID.
     * 
     * @param userId the ID of the user to be deleted
     * @throws UserDAOException if an error occurs while deleting the user
     * @throws UserNotFoundException if the user is not found
     */
    void deleteUser(int userId) throws UserDAOException, UserNotFoundException;
    
    /**
     * Retrieves a user based on the user's ID.
     * 
     * @param userId the ID of the user to be retrieved
     * @return the user with the specified ID
     * @throws UserDAOException if an error occurs while retrieving the user
     * @throws UserNotFoundException if the user is not found
     */
    UserDTO getUserById(int userId) throws UserDAOException, UserNotFoundException;
    
    /**
     * Retrieves a user based on the user's username.
     * 
     * @param username the username of the user to be retrieved
     * @return the user with the specified username
     * @throws UserDAOException if an error occurs while retrieving the user
     * @throws UserNotFoundException if the user is not found
     */
    UserDTO getUserByUsername(String username) throws UserDAOException, UserNotFoundException;
    
    /**
     * Retrieves a list of all users.
     * 
     * @return a list of all users
     * @throws UserDAOException if an error occurs while retrieving the users
     */
    List<UserDTO> getAllUsers() throws UserDAOException;
}
