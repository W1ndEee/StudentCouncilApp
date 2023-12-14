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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminPage1 extends JFrame {

	private JPanel contentPane;
	
	// Method to remove empty slots from the array
    private static void removeEmptySlots(String[] names, int[] votes) {
        int emptySlots = 0;
        
        // Iterate through the array
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("")) {
                emptySlots++;
            } else if (emptySlots > 0) {
                // Shift non-empty values to fill empty slots
                names[i - emptySlots] = names[i];
                names[i] = "";
                
                // Shift corresponding values in votes array
                votes[i - emptySlots] = votes[i];
                votes[i] = 0; // You may want to set this to a default value or handle it differently
            }
        }
        
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage1 frame = new AdminPage1();
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
	public AdminPage1() {
		Connection c = null;
	    Statement stmt = null;
	    int rows = 2;
	    
	    //FIRST DB CONNECTION TO GET ROWS SO THAT THE PROGRAM DOESN'T BREAK
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/daniel");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         
	         //GET ROWS
	         ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM TEST3");
	         rs3.next();
	         rows = rs3.getInt("COUNT");
	         System.out.println(rows);
	         
	         /*
	         //GET NAMES
	         ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TEST3 ORDER BY VOTES DESC;" );
	         for (int j = 0; j<= 10; j++) {
	        	 rs.next();
		         names[j] = rs.getString("NAME");
	         }
	         
	         //GET VOTES
	         ResultSet rs2 = stmt.executeQuery( "SELECT VOTES FROM TEST3 ORDER BY VOTES DESC;" );
	         for (int i = 0; i<= 10; i++) {
	        	 rs2.next();
		         votes[i] = rs2.getInt("VOTES");
	         }
	         */
	         
	         stmt.close();
	         c.commit();
	         c.close();
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      
	      //SECOND DB CONNECTION TO GET NAMES & VOTES
	      String[] names = new String[rows];
		  int[] votes = new int[rows];
		    
	      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/daniel");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         
		       //GET NAMES
		         ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TEST3 ORDER BY VOTES DESC;" );
		         for (int j = 0; j<= rows - 1; j++) {
		        	 rs.next();
			         names[j] = rs.getString("NAME");
		         }
		         
		         //GET VOTES
		         ResultSet rs2 = stmt.executeQuery( "SELECT VOTES FROM TEST3 ORDER BY VOTES DESC;" );
		         for (int i = 0; i<= rows - 1; i++) {
		        	 rs2.next();
			         votes[i] = rs2.getInt("VOTES");
		         }
		         
		         
		         stmt.close();
		         c.commit();
		         c.close();
		         
		      } catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		      }
	      
	    removeEmptySlots(names, votes);
	    
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListOfVoters = new JButton("List of Voters");
		btnListOfVoters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VoterList1 votelist = new VoterList1();
				votelist.setVisible(true);
			}
		});
		btnListOfVoters.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnListOfVoters.setBounds(539, 315, 171, 38);
		getContentPane().add(btnListOfVoters);
		
		JButton btnListOfCandidates = new JButton("List of Candidates");
		btnListOfCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CandidateList1 candlist = new CandidateList1();
				candlist.setVisible(true);
				
			}
		});
		
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
		
		btnListOfCandidates.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnListOfCandidates.setBounds(539, 223, 171, 38);
		getContentPane().add(btnListOfCandidates);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Main Menu");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblWelcomeToThe.setBounds(244, 25, 425, 48);
		getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCurrentVotes = new JLabel("Current votes:");
		lblCurrentVotes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentVotes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCurrentVotes.setBounds(89, 155, 158, 37);
		getContentPane().add(lblCurrentVotes);
		
		JLabel Votes1 = new JLabel("1. " + names[0] + " - " + votes[0]);
		if (names[0].equals("")) {
			Votes1.setText("");
		}
		Votes1.setHorizontalAlignment(SwingConstants.LEFT);
		Votes1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes1.setBounds(89, 192, 158, 37);
		contentPane.add(Votes1);
		
		JLabel Votes2 = new JLabel("2. " + names[1] + " - " + votes[1]);
		if (names[1].equals("")) {
			Votes2.setText("");
		}
		Votes2.setHorizontalAlignment(SwingConstants.LEFT);
		Votes2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes2.setBounds(89, 234, 158, 37);
		contentPane.add(Votes2);
		
		JLabel Votes3 = new JLabel("3. " + names[2] + " - " + votes[2]);
		if (names[2].equals("")) {
			Votes3.setText("");
		}
		Votes3.setHorizontalAlignment(SwingConstants.LEFT);
		Votes3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes3.setBounds(89, 276, 158, 37);
		contentPane.add(Votes3);
		
		JLabel Votes4 = new JLabel("4. " + names[3] + " - " + votes[3]);
		if (names[3].equals("")) {
			Votes4.setText("");
		}
		Votes4.setHorizontalAlignment(SwingConstants.LEFT);
		Votes4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes4.setBounds(89, 318, 158, 37);
		contentPane.add(Votes4);
		
		JLabel Votes5 = new JLabel("5. " + names[4] + " - " + votes[4]);
		if (names[4].equals("")) {
			Votes5.setText("");
		}
		Votes5.setHorizontalAlignment(SwingConstants.LEFT);
		Votes5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes5.setBounds(89, 360, 158, 37);
		contentPane.add(Votes5);
		
		JLabel Votes6 = new JLabel("6. " + names[5] + " - " + votes[5]);
		if (names[5].equals("")) {
			Votes6.setText("");
		}
		Votes6.setHorizontalAlignment(SwingConstants.LEFT);
		Votes6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes6.setBounds(89, 402, 158, 37);
		contentPane.add(Votes6);
		
		JLabel Votes7 = new JLabel("7. " + names[6] + " - " + votes[6]);
		if (names[6].equals("")) {
			Votes7.setText("");
		}
		Votes7.setHorizontalAlignment(SwingConstants.LEFT);
		Votes7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes7.setBounds(89, 444, 158, 37);
		contentPane.add(Votes7);
		
		JLabel Votes8 = new JLabel("8. " + names[7] + " - " + votes[7]);
		if (names[7].equals("")) {
			Votes8.setText("");
		}
		Votes8.setHorizontalAlignment(SwingConstants.LEFT);
		Votes8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes8.setBounds(89, 486, 158, 37);
		contentPane.add(Votes8);
		
		JLabel Votes9 = new JLabel("9. " + names[8] + " - " + votes[8]);
		if (names[8].equals("")) {
			Votes9.setText("");
		}
		Votes9.setHorizontalAlignment(SwingConstants.LEFT);
		Votes9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Votes9.setBounds(89, 528, 158, 37);
		contentPane.add(Votes9);
	}
}
