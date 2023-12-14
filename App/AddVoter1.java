package App;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;

public class AddVoter1 extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField yearfield;
	private JTextField idfield;
	private JTextField fingerprintfield;
	private JTextField emailfield;
	private JTextField passwordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVoter1 frame = new AddVoter1();
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
	public AddVoter1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddVoter = new JLabel("Add Voter");
		lblAddVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddVoter.setBounds(225, 47, 425, 48);
		getContentPane().add(lblAddVoter);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFullName.setBounds(171, 118, 214, 50);
		getContentPane().add(lblFullName);
		
		namefield = new JTextField();
		namefield.setColumns(10);
		namefield.setBounds(349, 118, 256, 50);
		getContentPane().add(namefield);
		
		JLabel lblYearLevel = new JLabel("Year Level:");
		lblYearLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYearLevel.setBounds(171, 180, 214, 50);
		getContentPane().add(lblYearLevel);
		
		yearfield = new JTextField();
		yearfield.setColumns(10);
		yearfield.setBounds(349, 180, 256, 50);
		getContentPane().add(yearfield);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudentId.setBounds(171, 242, 214, 50);
		getContentPane().add(lblStudentId);
		
		idfield = new JTextField();
		idfield.setColumns(10);
		idfield.setBounds(349, 242, 256, 50);
		getContentPane().add(idfield);
		
		JLabel lblFingerprintId = new JLabel("Fingerprint ID:");
		lblFingerprintId.setHorizontalAlignment(SwingConstants.CENTER);
		lblFingerprintId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFingerprintId.setBounds(156, 304, 214, 50);
		getContentPane().add(lblFingerprintId);
		
		fingerprintfield = new JTextField();
		fingerprintfield.setColumns(10);
		fingerprintfield.setBounds(349, 304, 256, 50);
		getContentPane().add(fingerprintfield);
		
		JLabel lblSchoolEmail = new JLabel("School Email:");
		lblSchoolEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSchoolEmail.setBounds(166, 366, 214, 50);
		getContentPane().add(lblSchoolEmail);
		
		emailfield = new JTextField();
		emailfield.setColumns(10);
		emailfield.setBounds(349, 366, 256, 50);
		getContentPane().add(emailfield);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(171, 428, 214, 50);
		getContentPane().add(lblPassword);
		
		passwordfield = new JTextField();
		passwordfield.setColumns(10);
		passwordfield.setBounds(349, 428, 256, 50);
		getContentPane().add(passwordfield);
		
		JButton btnBackToList = new JButton("Back to list");
		btnBackToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VoterList1 voterlist = new VoterList1();
				voterlist.setVisible(true);
			}
		});
		btnBackToList.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToList.setBounds(214, 510, 171, 38);
		getContentPane().add(btnBackToList);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
			    Statement stmt = null;
				String inputname = namefield.getText();
				String inputyear = yearfield.getText();
				String inputid = idfield.getText();
				String inputemail = emailfield.getText();
				String inputpassword = passwordfield.getText();
				int intyear = Integer.valueOf(inputyear);
				int intid = Integer.valueOf(inputid);
				
				try {
			         Class.forName("org.postgresql.Driver");
			         c = DriverManager
			            .getConnection("jdbc:postgresql://localhost:5432/daniel");
			         c.setAutoCommit(false);
			         stmt = c.createStatement();
			         
			         stmt = c.createStatement();
			         String sql = "INSERT INTO TEST3 (STUDENTID,NAME,YEARLEVEL,VOTES,PICTURE) "
			            + "VALUES (" + intid + ", '" + inputname + "', " + intyear + ", 0, 'lib/" + intid + ".jpg');";
			         stmt.execute(sql); 
			         
			         stmt = c.createStatement();
			         ResultSet rs = stmt.executeQuery( "SELECT * FROM TEST3 ORDER BY STUDENTID ASC;" );
			         while ( rs.next() ) {
			            int studentid = rs.getInt("studentid");
			            String  name = rs.getString("name");
			            int yearlevel  = rs.getInt("yearlevel");
			            int  votes = rs.getInt("votes");
			            String picture = rs.getString("picture");
			            System.out.println( "STUDENTID = " + studentid );
			            System.out.println( "NAME = " + name );
			            System.out.println( "YEARLEVEL = " + yearlevel );
			            System.out.println( "VOTES = " + votes );
			            System.out.println( "PICTURE = " + picture );
			            System.out.println();
			         }
			         rs.close(); 
					 stmt.close();
			         c.commit();
			         c.close();
			         
			      } catch ( Exception x ) {
			         System.err.println( x.getClass().getName()+": "+ x.getMessage() );
			         System.exit(0);
			      }
				
				JOptionPane.showMessageDialog(null, "Candidate added: " + inputname + ", Year " + intyear + ", Student ID: " + intid);
				JOptionPane.showMessageDialog(null, "If you made a mistake, don't change any values in the text field and click Revert/Delete.");
			}
		});
		btnConfirm.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnConfirm.setBounds(434, 510, 171, 38);
		getContentPane().add(btnConfirm);
	}

}
