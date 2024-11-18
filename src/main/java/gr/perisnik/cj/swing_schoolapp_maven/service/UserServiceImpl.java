package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.IUserDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.UserDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.User;

/**
 * Implementation of the IUserService interface for managing user operations.
 * This class provides business logic and transaction management for user entities.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class UserServiceImpl implements IUserService {
    
    private IUserDAO userDAO = new UserDAOImpl();
    
    /**
     * Adds a new user.
     * 
     * @param userDTO the user data transfer object
     * @return the added user
     * @throws UserDAOException if an error occurs while adding the user
     */
    @Override
    public UserDTO addUser(UserDTO userDTO) throws UserDAOException {
        User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
        user = userDAO.addUser(user);
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }
    
    /**
     * Updates an existing user.
     * 
     * @param userDTO the user data transfer object
     * @return the updated user
     * @throws UserDAOException if an error occurs while updating the user
     */
    @Override
    public UserDTO updateUser(UserDTO userDTO) throws UserDAOException {
        User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
        user = userDAO.updateUser(user);
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }
    
    @Override
    public void deleteUser(int userId) throws UserDAOException {
        userDAO.deleteUser(userId);
    }
    
    @Override
    public UserDTO getUserById(int userId) throws UserDAOException {
        User user = userDAO.getUserById(userId);
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }
    
    @Override
    public UserDTO getUserByUsername(String username) throws UserDAOException {
        User user = userDAO.getUserByUsername(username);
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }
    
    @Override
    public List<UserDTO> getAllUsers() throws UserDAOException {
        List<User> users = userDAO.getAllUsers();
        return users.stream()
            .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getPassword()))
            .collect(Collectors.toList());
    }
}
