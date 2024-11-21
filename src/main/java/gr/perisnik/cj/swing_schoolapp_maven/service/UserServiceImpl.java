package gr.perisnik.cj.swing_schoolapp_maven.service;

import java.util.List;
import java.util.stream.Collectors;

import gr.perisnik.cj.swing_schoolapp_maven.dao.IUserDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.UserDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.User;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.UserNotFoundException;

/**
 * Implementation of the IUserService interface for managing user operations.
 * This class provides business logic and transaction management for user entities.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class UserServiceImpl implements IUserService {
    
    private IUserDAO userDAO = new UserDAOImpl();
    
    public UserServiceImpl(IUserDAO userDAO) {
        super();
        this.userDAO = userDAO;
    }
    
    @Override
    public UserDTO addUser(UserDTO userDTO) throws UserDAOException {
        if (userDTO == null) {
            return null;
        }
        
        try {
            User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
            user = userDAO.addUser(user);
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public UserDTO updateUser(UserDTO userDTO) throws UserDAOException, UserNotFoundException {
        if (userDTO == null) {
            return null;
        }
        
        try {
            if (userDAO.getUserById(userDTO.getId()) == null) {
                throw new UserNotFoundException("User with ID " + userDTO.getId() + " not found");
            }
            User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
            user = userDAO.updateUser(user);
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public void deleteUser(int userId) throws UserDAOException, UserNotFoundException {
        try {
            if (userDAO.getUserById(userId) == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found");
            }
            userDAO.deleteUser(userId);
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public UserDTO getUserById(int userId) throws UserDAOException, UserNotFoundException {
        try {
            User user = userDAO.getUserById(userId);
            if (user == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found");
            }
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public UserDTO getUserByUsername(String username) throws UserDAOException, UserNotFoundException {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }
        
        try {
            User user = userDAO.getUserByUsername(username);
            if (user == null) {
                throw new UserNotFoundException("User with username " + username + " not found");
            }
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public List<UserDTO> getAllUsers() throws UserDAOException {
        try {
            List<User> users = userDAO.getAllUsers();
            return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getPassword()))
                .collect(Collectors.toList());
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}