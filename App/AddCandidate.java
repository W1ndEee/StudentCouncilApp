package App;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddCandidate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCandidate window = new AddCandidate();
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
	public AddCandidate() {
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
		
		JLabel lblAddVoter = new JLabel("Add Candidate");
		lblAddVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddVoter.setBounds(225, 47, 425, 48);
		frame.getContentPane().add(lblAddVoter);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFullName.setBounds(171, 215, 214, 50);
		frame.getContentPane().add(lblFullName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(349, 215, 256, 50);
		frame.getContentPane().add(textField);
		
		JLabel lblYearLevel = new JLabel("Year Level:");
		lblYearLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYearLevel.setBounds(171, 277, 214, 50);
		frame.getContentPane().add(lblYearLevel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(349, 277, 256, 50);
		frame.getContentPane().add(textField_1);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudentId.setBounds(171, 339, 214, 50);
		frame.getContentPane().add(lblStudentId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(349, 339, 256, 50);
		frame.getContentPane().add(textField_2);
		
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
