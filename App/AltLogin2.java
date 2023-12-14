package App;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AltLogin2 extends JFrame {
	public static String votername = "";
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltLogin2 frame = new AltLogin2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltLogin2() {
		Connection c = null;
	    Statement stmt = null;
	    String[] username = new String[9];
	    String[] password = new String[9];
	    Boolean[] votestatus = new Boolean[9];
	    String[] name = new String[9];
		try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/daniel");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         
	         //GET EMAIL
	         ResultSet rs = stmt.executeQuery( "SELECT EMAIL FROM TESTCAND ORDER BY STUDENTID ASC;" );
	         int i = 0;
	         while (rs.next() && i <= 8) {
	             username[i] = rs.getString("EMAIL");
	             i++;
	         }
	         /*
	         for (int i = 0; i<= 8; i++) {
	        	 rs.next();
	        	 username[i] = rs.getString("EMAIL");
	         } */
	         
	         //GET PASSWORD
	         ResultSet rs2 = stmt.executeQuery( "SELECT PASSWORD FROM TESTCAND ORDER BY STUDENTID ASC;" );
	         int j = 0;
	         while (rs2.next() && j <= 8) {
	             password[j] = rs2.getString("PASSWORD");
	             j++;
	         }
	         /*
	         for (int j = 0; j<= 8; j++) {
	        	 rs2.next();
		         password[j] = rs2.getString("PASSWORD");
	         } */
	         
	       //GET VOTESTATUS
	         ResultSet rs3 = stmt.executeQuery( "SELECT VOTESTATUS FROM TESTCAND ORDER BY STUDENTID ASC;" );
	         int x = 0;
	         while (rs3.next() && x <= 8) {
	             votestatus[x] = rs3.getBoolean("VOTESTATUS");
	             x++;
	         }
	         
	         //GET VOTER NAME FOR NEXT PANEL
	         ResultSet rs4 = stmt.executeQuery( "SELECT NAME FROM TESTCAND ORDER BY STUDENTID ASC;" );
	         int p = 0;
	         while (rs4.next() && p <= 8) {
	             name[p] = rs4.getString("NAME");
	             p++;
	         }
	         
			 stmt.close();
	         c.commit();
	         c.close();
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
		
		for (int k = 0; k<= 8; k++) {
			System.out.println("Email: " + username[k] + " Password: " + password[k] + " Vote status: " + votestatus[k] + " " + name[k]);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(421, 303, 256, 50);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(421, 215, 256, 50);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(348, 396, 179, 38);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminusr = "admin";
				String adminpass = "1234";
				String inputusr = textField.getText();
				char[] inputpass = passwordField.getPassword();
				String usrpass = String.valueOf(inputpass);
				for (int i = 0; i<= 8; i++) {
					if (inputusr.equals(adminusr) && usrpass.equals(adminpass)) {
						dispose();
						AdminPage1 adminp = new AdminPage1();
						adminp.setVisible(true);
					}
					else if (inputusr.equals(username[i]) && usrpass.equals(password[i])) {
						if (votestatus[i] == true) {
							JOptionPane.showMessageDialog(null, "You have already voted! Thank you!");
						}
						else {
							votername = name[i];
							dispose();
							VotingPage1 votep = new VotingPage1();
							votep.setVisible(true);
						}
					}
				}		
			}
		}); 
		
		
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FingerprintLogin1 finlog = new FingerprintLogin1();
				finlog.setVisible(true);
			}
		});
		btnNewButton.setBounds(45, 6, 50, 50);
		getContentPane().add(btnNewButton);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your credentials");
		lblPleaseEnterYour.setBounds(165, 69, 569, 98);
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		getContentPane().add(lblPleaseEnterYour);
		
		JLabel lblNewLabel = new JLabel("Back to fingerprint");
		lblNewLabel.setBounds(6, 59, 124, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblScanner = new JLabel("scanner");
		lblScanner.setBounds(6, 78, 124, 16);
		lblScanner.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblScanner);
		
		JLabel lblSchoolEmail = new JLabel("School email:");
		lblSchoolEmail.setBounds(225, 215, 214, 50);
		lblSchoolEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		getContentPane().add(lblSchoolEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(240, 303, 214, 50);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		getContentPane().add(lblPassword);
		
	}
}
