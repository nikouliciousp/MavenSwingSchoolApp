package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;

import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;

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
     */
    UserDTO updateUser(UserDTO user) throws UserDAOException;
    
    void deleteUser(int userId) throws UserDAOException;
    
    UserDTO getUserById(int userId) throws UserDAOException;
    
    UserDTO getUserByUsername(String username) throws UserDAOException;
    
    List<UserDTO> getAllUsers() throws UserDAOException;
}
