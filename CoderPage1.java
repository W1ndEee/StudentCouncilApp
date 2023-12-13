import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CoderPage1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoderPage1 frame = new CoderPage1();
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
	public CoderPage1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ResetButton = new JButton("Reset all Votes and Voter Status");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
			    Statement stmt = null;
			    Boolean flag = false;
				try {
			         Class.forName("org.postgresql.Driver");
			         c = DriverManager
			            .getConnection("jdbc:postgresql://localhost:5432/daniel");
			         c.setAutoCommit(false);
			         stmt = c.createStatement();
			         
			         String sql = "UPDATE TEST3 SET VOTES = 0";
			         stmt.executeUpdate(sql);
			         
			         sql = "UPDATE TESTCAND SET VOTESTATUS = false";
			         stmt.execute(sql);
			         
			         System.out.println("VOTERS:");
			         ResultSet rs = stmt.executeQuery( "SELECT * FROM TESTCAND;" );
			         while ( rs.next() ) {
			            int studentid = rs.getInt("studentid");
			            String  name = rs.getString("name");
			            int yearlevel  = rs.getInt("yearlevel");
			            String  email = rs.getString("email");
			            String password = rs.getString("password");
			            Boolean votestatus = rs.getBoolean("votestatus");
			            System.out.println( "STUDENTID = " + studentid );
			            System.out.println( "NAME = " + name );
			            System.out.println( "YEARLEVEL = " + yearlevel );
			            System.out.println( "EMAIL = " + email );
			            System.out.println( "PASSWORD = " + password );
			            System.out.println("VOTESTATUS = " + votestatus);
			            System.out.println();
			         }
			         rs.close(); 
			         
			         System.out.println("CANDIDATES:");
			         ResultSet rs2 = stmt.executeQuery( "SELECT * FROM TEST3 ORDER BY STUDENTID ASC;" );
			         while ( rs2.next() ) {
			            int studentid = rs2.getInt("studentid");
			            String  name = rs2.getString("name");
			            int yearlevel  = rs2.getInt("yearlevel");
			            int  votes = rs2.getInt("votes");
			            String pic = rs2.getString("picture");
			            System.out.println( "STUDENTID = " + studentid );
			            System.out.println( "NAME = " + name );
			            System.out.println( "YEARLEVEL = " + yearlevel );
			            System.out.println( "VOTES = " + votes );
			            System.out.println( "PICTURE = " + pic );
			            System.out.println();
			            flag = true;
			         }
			         rs2.close();
			         
			         
					 stmt.close();
			         c.commit();
			         c.close();
			         
			      } catch ( Exception x ) {
			         System.err.println( x.getClass().getName()+": "+ x.getMessage() );
			         System.exit(0);
			      }
				
				if (flag) {
					dispose();
					AltLogin1 altlog = new AltLogin1();
					altlog.setVisible(true);
				}
				
				String words = "Now I Am Become Death, the Destroyer of Worlds.";
				String quote = "\"" + words + "\"";
				JOptionPane.showMessageDialog(null, quote + " - J. Robert Oppenheimer");
				
				
			}
		});
		ResetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ResetButton.setBounds(236, 257, 426, 75);
		contentPane.add(ResetButton);
		
		JLabel lblNewLabel = new JLabel("Extremely Catastrophic");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(236, 205, 426, 51);
		contentPane.add(lblNewLabel);
	}
}
