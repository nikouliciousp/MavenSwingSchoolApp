package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

import org.mindrot.jbcrypt.BCrypt;

import gr.perisnik.cj.swing_schoolapp_maven.Main;
import gr.perisnik.cj.swing_schoolapp_maven.dto.UserDTO;
import gr.perisnik.cj.swing_schoolapp_maven.service.IUserService;
import gr.perisnik.cj.swing_schoolapp_maven.service.UserServiceImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.UserDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.UserDAOException;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class InsertUserForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsername;
    private JPasswordField textPassword;

    private IUserService userService = new UserServiceImpl(new UserDAOImpl());

    /**
     * Create the frame.
     */
    public InsertUserForm() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                textUsername.setText("");
                textPassword.setText("");
            }
        });
        setTitle("Insert User");
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
        lblUsername.setToolTipText("");
        lblUsername.setBounds(63, 62, 89, 33);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPassword.setForeground(Color.BLUE);
        lblPassword.setBounds(66, 106, 86, 33);
        contentPane.add(lblPassword);

        textUsername = new JTextField();
        textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textUsername.setBounds(150, 66, 210, 25);
        contentPane.add(textUsername);
        textUsername.setColumns(50);

        textPassword = new JPasswordField();
        textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textPassword.setBounds(150, 110, 210, 25);
        contentPane.add(textPassword);

        JButton btnInsert = new JButton("INSERT");
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputUsername = textUsername.getText().trim();
                String inputPassword = String.valueOf(textPassword.getPassword()).trim();

                if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    String hashedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt(12));
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUsername(inputUsername);
                    userDTO.setPassword(hashedPassword);

                    UserDTO addedUser = userService.addUser(userDTO);

                    JOptionPane.showMessageDialog(null, "User " + addedUser.getUsername() + " inserted successfully!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);

                } catch (UserDAOException exc) {
                    JOptionPane.showMessageDialog(null, "Error: " + exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    exc.printStackTrace();
                }
            }
        });
        btnInsert.setForeground(Color.BLUE);
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnInsert.setBounds(220, 204, 89, 32);
        contentPane.add(btnInsert);

        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getInsertUserForm().setVisible(false);
                Main.getSearchUserForm().setVisible(true);
            }
        });
        btnClose.setForeground(Color.RED);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(319, 204, 89, 32);
        contentPane.add(btnClose);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 186, 382, 1);
        contentPane.add(separator);
    }
}