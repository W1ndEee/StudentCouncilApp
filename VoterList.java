
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;

public class VoterList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterList window = new VoterList();
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
	public VoterList() {
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
		
		JButton btnRemoveVoter = new JButton("Remove Voter");
		btnRemoveVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRemoveVoter.setBounds(569, 528, 171, 38);
		frame.getContentPane().add(btnRemoveVoter);
		
		JButton btnAddVoter = new JButton("Add Voter");
		btnAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddVoter.setBounds(296, 528, 171, 38);
		frame.getContentPane().add(btnAddVoter);
		
		JButton btnSearchByStatus = new JButton("Search by status");
		btnSearchByStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByStatus.setBounds(16, 361, 171, 38);
		frame.getContentPane().add(btnSearchByStatus);
		
		JButton btnSearchByYear = new JButton("Search by Year");
		btnSearchByYear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByYear.setBounds(16, 276, 171, 38);
		frame.getContentPane().add(btnSearchByYear);
		
		JButton btnSearchByName = new JButton("Search by Name");
		btnSearchByName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByName.setBounds(16, 192, 171, 38);
		frame.getContentPane().add(btnSearchByName);
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToMenu.setBounds(16, 21, 171, 38);
		frame.getContentPane().add(btnBackToMenu);
		
		JLabel lblVoterList = new JLabel("Voter List");
		lblVoterList.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoterList.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblVoterList.setBounds(324, 18, 268, 48);
		frame.getContentPane().add(lblVoterList);
	}
}
