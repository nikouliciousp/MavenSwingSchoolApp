package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.mindrot.jbcrypt.BCrypt;

import gr.perisnik.cj.swing_schoolapp_maven.Main;
import gr.perisnik.cj.swing_schoolapp_maven.service.IUserService;
import gr.perisnik.cj.swing_schoolapp_maven.service.UserServiceImpl;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.UserNotFoundException;
import gr.perisnik.cj.swing_schoolapp_maven.dao.IUserDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.UserDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateDeleteUserForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private IUserDAO userDAO = new UserDAOImpl();
    private IUserService userService = new UserServiceImpl(userDAO);
    private UserDTO userDTO;

    private JPanel contentPane;
    private JTextField textUsername;
    private JTextField textId;
    private JTextField textPassword;

    public UpdateDeleteUserForm() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                try {
                    String username = Main.getSearchUserForm().getInputUsername();  
                    userDTO = userService.getUserByUsername(username);

                    if (userDTO != null) {
                        textId.setText(String.valueOf(userDTO.getId()));
                        textUsername.setText(userDTO.getUsername());
                        textPassword.setText("*********");
                    } else {
                        textId.setText("");
                        textUsername.setText("");
                        textPassword.setText("");
                    }
                } catch (UserDAOException | UserNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    textId.setText("");
                    textUsername.setText("");
                    textPassword.setText("");
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                textId.setText("");
                textUsername.setText("");
                textPassword.setText("");
            }
        });

        setTitle("Update/Delete User");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(210, 255, 255));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.BLUE);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsername.setBounds(66, 82, 90, 33);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPassword.setForeground(Color.BLUE);
        lblPassword.setBounds(66, 126, 86, 33);
        contentPane.add(lblPassword);

        textUsername = new JTextField();
        textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textUsername.setBounds(151, 86, 210, 25);
        contentPane.add(textUsername);

        textPassword = new JTextField();
        textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textPassword.setBounds(151, 130, 210, 25);
        contentPane.add(textPassword);

        JLabel lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setForeground(Color.BLUE);
        lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblId.setBounds(66, 38, 77, 33);
        contentPane.add(lblId);

        textId = new JTextField();
        textId.setEditable(false);
        textId.setBackground(new Color(213, 255, 255));
        textId.setHorizontalAlignment(SwingConstants.LEFT);
        textId.setBounds(151, 44, 60, 25);
        contentPane.add(textId);

        // Button to update user
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputUsername = textUsername.getText().trim();
                String inputPassword = textPassword.getText().trim();
                String inputId = textId.getText().trim();

                if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No records updated", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                	String hashedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt(12));
                    UserDTO updatedUserDTO = new UserDTO();
                    updatedUserDTO.setId(Integer.parseInt(inputId));
                    updatedUserDTO.setUsername(inputUsername);
                    updatedUserDTO.setPassword(hashedPassword);

                    userService.updateUser(updatedUserDTO);

                    JOptionPane.showMessageDialog(null, "User updated successfully!", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                } catch (UserDAOException | UserNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUpdate.setForeground(Color.BLUE);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnUpdate.setBounds(18, 193, 120, 30);
        contentPane.add(btnUpdate);

        // Button to delete user
        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputId = Integer.parseInt(textId.getText().trim());

                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "DELETE", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        userService.deleteUser(inputId);
                        textId.setText("");
                        textUsername.setText("");
                        textPassword.setText("");
                        JOptionPane.showMessageDialog(null, "User deleted successfully!", "DELETE", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException | UserDAOException | UserNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnDelete.setForeground(Color.RED);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(156, 193, 120, 30);
        contentPane.add(btnDelete);

        // Button to close the form
        JButton btnClose = new JButton("CLOSE");
        btnClose.setForeground(Color.RED);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getUpdateDeleteUserForm().setVisible(false);
                Main.getSearchUserForm().setVisible(true);
            }
        });
        btnClose.setBounds(294, 193, 120, 30);
        contentPane.add(btnClose);
    }
}
