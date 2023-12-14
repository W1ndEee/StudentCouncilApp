package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddVoter {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVoter window = new AddVoter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddVoter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddVoter = new JLabel("Add Voter");
		lblAddVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddVoter.setBounds(225, 47, 425, 48);
		frame.getContentPane().add(lblAddVoter);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFullName.setBounds(171, 118, 214, 50);
		frame.getContentPane().add(lblFullName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(349, 118, 256, 50);
		frame.getContentPane().add(textField);
		
		JLabel lblYearLevel = new JLabel("Year Level:");
		lblYearLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYearLevel.setBounds(171, 180, 214, 50);
		frame.getContentPane().add(lblYearLevel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(349, 180, 256, 50);
		frame.getContentPane().add(textField_1);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudentId.setBounds(171, 242, 214, 50);
		frame.getContentPane().add(lblStudentId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(349, 242, 256, 50);
		frame.getContentPane().add(textField_2);
		
		JLabel lblFingerprintId = new JLabel("Fingerprint ID:");
		lblFingerprintId.setHorizontalAlignment(SwingConstants.CENTER);
		lblFingerprintId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFingerprintId.setBounds(156, 304, 214, 50);
		frame.getContentPane().add(lblFingerprintId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(349, 304, 256, 50);
		frame.getContentPane().add(textField_3);
		
		JLabel lblSchoolEmail = new JLabel("School Email:");
		lblSchoolEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSchoolEmail.setBounds(166, 366, 214, 50);
		frame.getContentPane().add(lblSchoolEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(349, 366, 256, 50);
		frame.getContentPane().add(textField_4);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(171, 428, 214, 50);
		frame.getContentPane().add(lblPassword);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(349, 428, 256, 50);
		frame.getContentPane().add(textField_5);
		
		JButton btnBackToList = new JButton("Back to list");
		btnBackToList.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToList.setBounds(214, 510, 171, 38);
		frame.getContentPane().add(btnBackToList);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnConfirm.setBounds(434, 510, 171, 38);
		frame.getContentPane().add(btnConfirm);
	}
}
