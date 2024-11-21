package gr.perisnik.cj.swing_schoolapp_maven;


import java.awt.EventQueue;

import gr.perisnik.cj.swing_schoolapp_maven.controllerview.InsertStudentForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.InsertTeacherForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.InsertUserForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.Menu;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.SearchStudentForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.SearchTeacherForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.SearchUserForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.UpdateDeleteStudentForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.UpdateDeleteTeacherForm;
import gr.perisnik.cj.swing_schoolapp_maven.controllerview.UpdateDeleteUserForm;

public class Main {
	private static WelcomeWindow welcomeWindow;
	private static LoginForm loginForm;
	
	private static SearchUserForm searchUserForm;
	private static InsertUserForm insertUserForm;
	private static UpdateDeleteUserForm updateDeleteUserForm;
	
	private static Menu menu;
	private static SearchTeacherForm searchTeacherForm;
	private static InsertTeacherForm insertTeacherForm;
	private static UpdateDeleteTeacherForm updateDeleteTeacherForm;
	private static SearchStudentForm searchStudentForm;
	private static InsertStudentForm insertStudentForm;
	private static UpdateDeleteStudentForm updateDeleteStudentForm;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					welcomeWindow = new WelcomeWindow();
					welcomeWindow.setLocationRelativeTo(null);
					welcomeWindow.setVisible(true);
					
					loginForm = new LoginForm();
					loginForm.setLocationRelativeTo(null);
					loginForm.setVisible(false);
					
					searchUserForm = new SearchUserForm();
					searchUserForm.setLocationRelativeTo(null);
					searchUserForm.setVisible(false);
					
					insertUserForm = new InsertUserForm();
					insertUserForm.setLocationRelativeTo(null);
					insertUserForm.setVisible(false);
					
					updateDeleteUserForm = new UpdateDeleteUserForm();
					updateDeleteUserForm.setLocationRelativeTo(null);
					updateDeleteUserForm.setVisible(false);
					
					menu = new Menu();
					menu.setLocationRelativeTo(null);
					menu.setVisible(false);
					
					searchTeacherForm = new SearchTeacherForm();
					searchTeacherForm.setLocationRelativeTo(null);
					searchTeacherForm.setVisible(false);
					
					insertTeacherForm = new InsertTeacherForm();
					insertTeacherForm.setLocationRelativeTo(null);
					insertTeacherForm.setVisible(false);
					
					updateDeleteTeacherForm = new UpdateDeleteTeacherForm();
					updateDeleteTeacherForm.setLocationRelativeTo(null);
					updateDeleteTeacherForm.setVisible(false);
					
					searchStudentForm = new SearchStudentForm();
					searchStudentForm.setLocationRelativeTo(null);
					searchStudentForm.setVisible(false);
								
					insertStudentForm = new InsertStudentForm();
					insertStudentForm.setLocationRelativeTo(null);
					insertStudentForm.setVisible(false);
					
					updateDeleteStudentForm = new UpdateDeleteStudentForm();
					updateDeleteStudentForm.setLocationRelativeTo(null);
					updateDeleteStudentForm.setVisible(false);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static WelcomeWindow getWelcomeWindow() {
		return welcomeWindow;
	}
	
	public static LoginForm getLoginForm() {
		return loginForm;
	}
	
	public static SearchUserForm getSearchUserForm() {
		return searchUserForm;
	}

	public static InsertUserForm getInsertUserForm() {
		return insertUserForm;
	}

	public static UpdateDeleteUserForm getUpdateDeleteUserForm() {
		return updateDeleteUserForm;
	}

	public static Menu getMenu() {
		return menu;
	}

	public static SearchTeacherForm getSearchTeacherForm() {
		return searchTeacherForm;
	}

	public static InsertTeacherForm getInsertTeacherForm() {
		return insertTeacherForm;
	}

	public static UpdateDeleteTeacherForm getUpdateDeleteTeacherForm() {
		return updateDeleteTeacherForm;
	}

	public static SearchStudentForm getSearchStudentForm() {
		return searchStudentForm;
	}

	public static InsertStudentForm getInsertStudentForm() {
		return insertStudentForm;
	}

	public static UpdateDeleteStudentForm getUpdateDeleteStudentForm() {
		return updateDeleteStudentForm;
	}
}
