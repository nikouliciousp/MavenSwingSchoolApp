package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import gr.perisnik.cj.swing_schoolapp_maven.Main;

import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchUserForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsername;
    private String inputUsername;

    /**
     * Create the frame.
     */
    public SearchUserForm() {
        // Clear input field when window is activated
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                textUsername.setText("");
            }
        });

        setTitle("Search/Insert User");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(210, 255, 255));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Username label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setForeground(Color.BLUE);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsername.setBounds(175, 28, 86, 33);
        contentPane.add(lblUsername);

        // Input field for username
        textUsername = new JTextField();
        textUsername.setHorizontalAlignment(SwingConstants.CENTER);
        textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textUsername.setBounds(113, 61, 210, 25);
        contentPane.add(textUsername);
        textUsername.setColumns(50);

        // Search button
        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputUsername = textUsername.getText().trim();
                if (!inputUsername.isEmpty()) {
                    Main.getSearchUserForm().setVisible(false);
                    Main.getUpdateDeleteUserForm().setVisible(true);
                } else {
                    // Display error if no username is provided
                    javax.swing.JOptionPane.showMessageDialog(SearchUserForm.this, "Please enter a username!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnSearch.setForeground(Color.BLUE);
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSearch.setBounds(164, 97, 109, 25);
        contentPane.add(btnSearch);

        // Insert button
        JButton btnInsert = new JButton("INSERT");
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getSearchUserForm().setVisible(false);
                Main.getInsertUserForm().setVisible(true);
            }
        });
        btnInsert.setForeground(Color.BLUE);
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnInsert.setBounds(157, 146, 120, 33);
        contentPane.add(btnInsert);

        // Close button
        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getSearchUserForm().setVisible(false);
                Main.getWelcomeWindow().setVisible(true);
            }
        });
        btnClose.setForeground(Color.RED);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(319, 204, 89, 32);
        contentPane.add(btnClose);

        // Separator
        JSeparator separator = new JSeparator();
        separator.setBounds(26, 192, 382, 1);
        contentPane.add(separator);

        // Search panel
        JPanel panelSearch = new JPanel();
        panelSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelSearch.setBounds(26, 28, 382, 103);
        contentPane.add(panelSearch);
        panelSearch.setLayout(null);

        // Insert panel
        JPanel panelInsert = new JPanel();
        panelInsert.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelInsert.setBounds(26, 137, 382, 50);
        contentPane.add(panelInsert);
        panelInsert.setLayout(null);
    }

    public String getInputUsername() {
        return inputUsername;
    }
}