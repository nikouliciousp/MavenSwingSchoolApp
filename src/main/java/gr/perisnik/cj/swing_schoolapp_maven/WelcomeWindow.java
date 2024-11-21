package gr.perisnik.cj.swing_schoolapp_maven;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Window.Type;

public class WelcomeWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public WelcomeWindow() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(198, 255, 255));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setBackground(new Color(225, 225, 225));
        btnEnter.setForeground(Color.BLUE);
        btnEnter.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnEnter.setBounds(134, 185, 183, 49);
        contentPane.add(btnEnter);
        
        JLabel lblManagment = new JLabel("Managment System");
        lblManagment.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagment.setForeground(Color.BLUE);
        lblManagment.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblManagment.setBounds(68, 96, 315, 30);
        contentPane.add(lblManagment);
        
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 28, 414, 111);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblSchool = new JLabel("to the School");
        lblSchool.setBounds(134, 39, 163, 30);
        panel.add(lblSchool);
        lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
        lblSchool.setForeground(Color.BLUE);
        lblSchool.setFont(new Font("Tahoma", Font.BOLD, 20));
        
                JLabel lblWelcome = new JLabel("Welcome");
                lblWelcome.setBounds(134, 11, 163, 30);
                panel.add(lblWelcome);
                lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
                lblWelcome.setForeground(Color.BLUE);
                lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                JLabel lblManagment_1 = new JLabel("Managment System");
                lblManagment_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblManagment_1.setForeground(Color.WHITE);
                lblManagment_1.setFont(new Font("Tahoma", Font.BOLD, 28));
                lblManagment_1.setBounds(60, 70, 315, 30);
                panel.add(lblManagment_1);
                
                JLabel lblSchool_1 = new JLabel("to the School");
                lblSchool_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblSchool_1.setForeground(Color.WHITE);
                lblSchool_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblSchool_1.setBounds(136, 40, 163, 30);
                panel.add(lblSchool_1);
                
                JLabel lblWelcome_1 = new JLabel("Welcome");
                lblWelcome_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblWelcome_1.setForeground(Color.WHITE);
                lblWelcome_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblWelcome_1.setBounds(135, 12, 163, 30);
                panel.add(lblWelcome_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 163, 414, 2);
        contentPane.add(separator);

        // Action listener to open the Menu window
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Main.getWelcomeWindow().setVisible(false);
				Main.getLoginForm().setVisible(true);
            }
        });
    }
}
