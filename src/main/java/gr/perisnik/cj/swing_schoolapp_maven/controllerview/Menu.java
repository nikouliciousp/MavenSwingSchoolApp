package gr.perisnik.cj.swing_schoolapp_maven.controllerview;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import gr.perisnik.cj.swing_schoolapp_maven.Main;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, -39, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 255, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitleOne = new JLabel("SCHOOL");
		lblTitleOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleOne.setForeground(Color.BLUE);
		lblTitleOne.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitleOne.setToolTipText("");
		lblTitleOne.setBounds(148, 12, 139, 33);
		contentPane.add(lblTitleOne);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setVisible(false);
            	Main.getWelcomeWindow().setVisible(true);	
			}
		});
		btnClose.setForeground(Color.RED);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(319, 218, 89, 32);
		contentPane.add(btnClose);
		
		JSeparator separatorOne = new JSeparator();
		separatorOne.setBounds(26, 69, 382, 1);
		contentPane.add(separatorOne);
		
		JLabel lblTitleSOne = new JLabel("MANAGMENT SYSTEM");
		lblTitleSOne.setToolTipText("");
		lblTitleSOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleSOne.setForeground(Color.BLUE);
		lblTitleSOne.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitleSOne.setBounds(94, 37, 247, 33);
		contentPane.add(lblTitleSOne);
		
		JLabel lblTitleTwo = new JLabel("SCHOOL");
		lblTitleTwo.setToolTipText("");
		lblTitleTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTwo.setForeground(Color.WHITE);
		lblTitleTwo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitleTwo.setBounds(146, 11, 139, 33);
		contentPane.add(lblTitleTwo);
		
		JLabel lblTitleSTwo = new JLabel("MANAGMENT SYSTEM");
		lblTitleSTwo.setToolTipText("");
		lblTitleSTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleSTwo.setForeground(Color.WHITE);
		lblTitleSTwo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitleSTwo.setBounds(92, 35, 247, 33);
		contentPane.add(lblTitleSTwo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(26, 85, 382, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTeachers = new JButton("");
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setVisible(false);
				Main.getSearchTeacherForm().setVisible(true);
			}
		});
		btnTeachers.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("insertTeacher.png")));
		btnTeachers.setBounds(10, 11, 39, 30);
		panel.add(btnTeachers);
		
		JLabel lblTeachers = new JLabel("Teachers");
		lblTeachers.setForeground(Color.BLUE);
		lblTeachers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTeachers.setBounds(58, 11, 92, 30);
		panel.add(lblTeachers);
		
		JButton btnStudents = new JButton("");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setVisible(false);
				Main.getSearchStudentForm().setVisible(true);
			}
		});
		btnStudents.setIcon(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("insertStudent.png")));
		btnStudents.setBounds(10, 59, 39, 30);
		panel.add(btnStudents);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setForeground(Color.BLUE);
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudents.setBounds(58, 59, 92, 30);
		panel.add(lblStudents);
		
		JSeparator separatorTwo = new JSeparator();
		separatorTwo.setBounds(26, 200, 382, 1);
		contentPane.add(separatorTwo);
	}
}
