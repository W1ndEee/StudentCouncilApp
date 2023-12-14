package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AdminPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
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
	public AdminPage() {
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
		
		JButton btnListOfVoters = new JButton("List of Voters");
		btnListOfVoters.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnListOfVoters.setBounds(539, 315, 171, 38);
		frame.getContentPane().add(btnListOfVoters);
		
		JButton btnListOfCandidates = new JButton("List of Candidates");
		btnListOfCandidates.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnListOfCandidates.setBounds(539, 223, 171, 38);
		frame.getContentPane().add(btnListOfCandidates);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Main Menu");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblWelcomeToThe.setBounds(244, 25, 425, 48);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCurrentVotes = new JLabel("Current votes:");
		lblCurrentVotes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentVotes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCurrentVotes.setBounds(89, 155, 158, 37);
		frame.getContentPane().add(lblCurrentVotes);
	}
}
