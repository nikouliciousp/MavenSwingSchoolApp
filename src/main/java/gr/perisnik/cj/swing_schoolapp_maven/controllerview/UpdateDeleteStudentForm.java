package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import gr.perisnik.cj.swing_schoolapp_maven.Main;
import gr.perisnik.cj.swing_schoolapp_maven.dao.IStudentDAO;
import gr.perisnik.cj.swing_schoolapp_maven.dao.StudentDAOImpl;
import gr.perisnik.cj.swing_schoolapp_maven.dao.exceptions.StudentDAOException;
import gr.perisnik.cj.swing_schoolapp_maven.dto.StudentDTO;
import gr.perisnik.cj.swing_schoolapp_maven.service.IStudentService;
import gr.perisnik.cj.swing_schoolapp_maven.service.StudentServiceImpl;
import gr.perisnik.cj.swing_schoolapp_maven.service.exceptions.StudentNotFoundException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class UpdateDeleteStudentForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private IStudentDAO studentDAO = new StudentDAOImpl();
    private IStudentService studentService = new StudentServiceImpl(studentDAO);
    private int listPosition;
    private int listSize;
    private List<StudentDTO> studentsDTO;

    private JPanel contentPane;
    private JTextField textLastname;
    private JTextField textFirstname;
    private JTextField textId;

    public UpdateDeleteStudentForm() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                try {
                    studentsDTO = studentService.getStudentByLastname(Main.getSearchStudentForm().getInputLastname());
                    listSize = studentsDTO.size();
                    listPosition = 0;

                    if (listSize > 0) {
                        updateFields();
                    } else {
                        clearFields();
                    }
                } catch (StudentDAOException | StudentNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                clearFields();
            }
        });

        setIconImage(Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("insertStudent.png")));
        setTitle("Update/Delete Student");
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
        lblLastname.setBounds(66, 82, 90, 33);
        contentPane.add(lblLastname);

        JLabel lblFirstname = new JLabel("Firstname");
        lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFirstname.setForeground(Color.BLUE);
        lblFirstname.setBounds(66, 126, 86, 33);
        contentPane.add(lblFirstname);

        textLastname = new JTextField();
        textLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textLastname.setBounds(151, 86, 210, 25);
        contentPane.add(textLastname);

        textFirstname = new JTextField();
        textFirstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFirstname.setBounds(151, 130, 210, 25);
        contentPane.add(textFirstname);

        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputId = Integer.parseInt(textId.getText().trim());
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete this Student?", "DELETE", JOptionPane.YES_NO_OPTION);

                    if (response == JOptionPane.YES_OPTION) {
                        studentService.deleteStudent(inputId);
                        studentsDTO.remove(listPosition);
                        listSize = studentsDTO.size();

                        if (listSize > 0) {
                            listPosition = Math.min(listPosition, listSize - 1);
                            updateFields();
                        } else {
                            clearFields();
                        }

                        JOptionPane.showMessageDialog(null, "Student deleted", "DELETE", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException | StudentDAOException | StudentNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnDelete.setForeground(Color.RED);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(220, 226, 89, 24);
        contentPane.add(btnDelete);

        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getUpdateDeleteStudentForm().setVisible(false);
                Main.getSearchStudentForm().setVisible(true);
            }
        });
        btnClose.setForeground(Color.RED);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(319, 226, 89, 24);
        contentPane.add(btnClose);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 186, 382, 1);
        contentPane.add(separator);

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

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputId = textId.getText().trim();
                String inputFirstname = textFirstname.getText().trim();
                String inputLastname = textLastname.getText().trim();

                if (inputLastname.isEmpty() || inputFirstname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No records updated", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(Integer.parseInt(inputId));
                    studentDTO.setFirstname(inputFirstname);
                    studentDTO.setLastname(inputLastname);

                    StudentDTO updatedStudent = studentService.updateStudent(studentDTO);
                    studentsDTO.set(listPosition, updatedStudent);

                    JOptionPane.showMessageDialog(null, "Records " + updatedStudent + " updated", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                } catch (NumberFormatException | StudentDAOException | StudentNotFoundException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUpdate.setForeground(Color.BLUE);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnUpdate.setBounds(121, 226, 89, 23);
        contentPane.add(btnUpdate);

        JButton btnStart = new JButton("");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listSize > 0) {
                    listPosition = 0;
                    StudentDTO student = studentsDTO.get(listPosition);
                    textId.setText(String.valueOf(student.getId()));
                    textLastname.setText(student.getLastname());
                    textFirstname.setText(student.getFirstname());
                }
            }
        });
        //btnStart.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("start.png")));
        btnStart.setBounds(267, 198, 35, 23);
        contentPane.add(btnStart);

        JButton btnPrevious = new JButton("");
        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listPosition > 0) {
                    listPosition--;
                    StudentDTO student = studentsDTO.get(listPosition);
                    textId.setText(String.valueOf(student.getId()));
                    textLastname.setText(student.getLastname());
                    textFirstname.setText(student.getFirstname());
                }
            }
        });
        //btnPrevious.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("previous.png")));
        btnPrevious.setBounds(303, 198, 35, 23);
        contentPane.add(btnPrevious);

        JButton btnNext = new JButton("");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listPosition < listSize - 1) {
                    listPosition++;
                    StudentDTO student = studentsDTO.get(listPosition);
                    textId.setText(String.valueOf(student.getId()));
                    textLastname.setText(student.getLastname());
                    textFirstname.setText(student.getFirstname());
                }
            }
        });
        //btnNext.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("next.png")));
        btnNext.setBounds(340, 198, 35, 23);
        contentPane.add(btnNext);

        JButton btnEnd = new JButton("");
        btnEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listSize > 0) {
                    listPosition = listSize - 1;
                    StudentDTO student = studentsDTO.get(listPosition);
                    textId.setText(String.valueOf(student.getId()));
                    textLastname.setText(student.getLastname());
                    textFirstname.setText(student.getFirstname());
                }
            }
        });
        //btnEnd.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("end.png")));
        btnEnd.setBounds(376, 198, 35, 23);
        contentPane.add(btnEnd);
    }

    public void clearFields() {
        textId.setText("");
        textFirstname.setText("");
        textLastname.setText("");
    }

    public void updateFields() {
        StudentDTO student = studentsDTO.get(listPosition);
        textId.setText(String.valueOf(student.getId()));
        textLastname.setText(student.getLastname());
        textFirstname.setText(student.getFirstname());
    }
}
