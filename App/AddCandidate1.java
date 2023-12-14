package App;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.lang.Integer.*;

public class AddCandidate1 extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField yearfield;
	private JTextField idfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCandidate1 frame = new AddCandidate1();
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
	public AddCandidate1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddVoter = new JLabel("Add/Remove Candidate");
		lblAddVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddVoter.setBounds(255, 47, 425, 48);
		getContentPane().add(lblAddVoter);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFullName.setBounds(171, 215, 214, 50);
		getContentPane().add(lblFullName);
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltLogin1 altlog = new AltLogin1();
				altlog.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogout.setBounds(754, 48, 140, 38);
		getContentPane().add(btnLogout);
		
		namefield = new JTextField();
		namefield.setColumns(10);
		namefield.setBounds(349, 215, 256, 50);
		getContentPane().add(namefield);
		
		JLabel lblYearLevel = new JLabel("Year Level:");
		lblYearLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYearLevel.setBounds(171, 277, 214, 50);
		getContentPane().add(lblYearLevel);
		
		yearfield = new JTextField();
		yearfield.setColumns(10);
		yearfield.setBounds(349, 277, 256, 50);
		getContentPane().add(yearfield);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudentId.setBounds(171, 339, 214, 50);
		getContentPane().add(lblStudentId);
		
		idfield = new JTextField();
		idfield.setColumns(10);
		idfield.setBounds(349, 339, 256, 50);
		getContentPane().add(idfield);
		
		JButton btnBackToList = new JButton("Back to list");
		btnBackToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CandidateList1 candlist = new CandidateList1();
				candlist.setVisible(true);
				
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
		
		JButton btnRevert = new JButton("Revert/Delete");
		btnRevert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
			    Statement stmt = null;
				String inputname = namefield.getText();
				String inputyear = yearfield.getText();
				String inputid = idfield.getText();
				int intyear = Integer.valueOf(inputyear);
				int intid = Integer.valueOf(inputid);
				
				try {
			         Class.forName("org.postgresql.Driver");
			         c = DriverManager
			            .getConnection("jdbc:postgresql://localhost:5432/daniel");
			         c.setAutoCommit(false);
			         stmt = c.createStatement();
			         
			         stmt = c.createStatement();
			         String sql = "DELETE FROM TEST3 WHERE NAME = '" + inputname + "'";
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
				
				JOptionPane.showMessageDialog(null, "Candidate " + inputname + " removed.");
				
			}
		});
		btnRevert.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRevert.setBounds(700, 510, 171, 38);
		contentPane.add(btnRevert);
	}

}
