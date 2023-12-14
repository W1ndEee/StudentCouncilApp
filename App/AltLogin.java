package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class AltLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltLogin window = new AltLogin();
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
	public AltLogin() {
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(421, 303, 256, 50);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(421, 215, 256, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogin.setBounds(348, 396, 179, 38);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(45, 6, 50, 50);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your credentials");
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPleaseEnterYour.setBounds(165, 69, 569, 98);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		JLabel lblNewLabel = new JLabel("Back to fingerprint");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 59, 124, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblScanner = new JLabel("scanner");
		lblScanner.setHorizontalAlignment(SwingConstants.CENTER);
		lblScanner.setBounds(6, 78, 124, 16);
		frame.getContentPane().add(lblScanner);
		
		JLabel lblSchoolEmail = new JLabel("School email:");
		lblSchoolEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSchoolEmail.setBounds(225, 215, 214, 50);
		frame.getContentPane().add(lblSchoolEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(240, 303, 214, 50);
		frame.getContentPane().add(lblPassword);
	}
}
