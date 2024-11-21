package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

import gr.perisnik.cj.swing_schoolapp_maven.Main;
import gr.perisnik.cj.swing_schoolapp_maven.dao.ITeacherDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.TeacherDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.TeacherDTO;
import gr.perisnik.cj.swing_schoolapp_maven.model.Teacher;
import gr.perisnik.cj.swing_schoolapp_maven.service.ITeacherService;
import gr.perisnik.cj.swing_schoolapp_maven.service.TeacherServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertTeacherForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private ITeacherDAO teacherDAO = new TeacherDAOImpl();
    private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
    
    private JPanel contentPane;
    private JTextField textLastname;
    private JTextField textFirstname;

    /**
     * Create the frame.
     */
    public InsertTeacherForm() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                textLastname.setText("");
                textFirstname.setText("");
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("insertTeacher.png")));
        setTitle("Insert Teacher");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(210, 255, 255));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblLastname = new JLabel("Lastname");
        lblLastname.setForeground(Color.BLUE);
        lblLastname.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblLastname.setToolTipText("");
        lblLastname.setBounds(66, 62, 86, 33);
        contentPane.add(lblLastname);
        
        JLabel lblFirstname = new JLabel("Firstname");
        lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFirstname.setForeground(Color.BLUE);
        lblFirstname.setBounds(66, 106, 86, 33);
        contentPane.add(lblFirstname);
        
        textLastname = new JTextField();
        textLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textLastname.setBounds(150, 66, 210, 25);
        contentPane.add(textLastname);
        textLastname.setColumns(50);
        
        textFirstname = new JTextField();
        textFirstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFirstname.setBounds(151, 110, 210, 25);
        contentPane.add(textFirstname);
        textFirstname.setColumns(50);
        
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(26, 30, 382, 145);
        contentPane.add(panel);
        
        JButton btnInsert = new JButton("INSERT");
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputFirstname = textFirstname.getText().trim();
                String inputLastname = textLastname.getText().trim(); 
                
                if (inputLastname.isEmpty() || inputFirstname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No records inserted", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {                
                    TeacherDTO teacherDTO = new TeacherDTO();
                    teacherDTO.setFirstname(inputFirstname);
                    teacherDTO.setLastname(inputLastname);

                    TeacherDTO addedTeacher = teacherService.addTeacher(teacherDTO);
                    
                    JOptionPane.showMessageDialog(null, "Records " + addedTeacher + " inserted", "INSERT", JOptionPane.PLAIN_MESSAGE);
                    
                } catch (TeacherDAOException exc) {
                    String message = exc.getMessage();
                    JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
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
                Main.getInsertTeacherForm().setVisible(false);
                Main.getSearchTeacherForm().setVisible(true);
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