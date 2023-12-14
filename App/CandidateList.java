package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CandidateList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandidateList window = new CandidateList();
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
	public CandidateList() {
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
		
		JButton btnAddremove = new JButton("Add/Remove");
		btnAddremove.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddremove.setBounds(503, 488, 171, 38);
		frame.getContentPane().add(btnAddremove);
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToMenu.setBounds(171, 488, 171, 38);
		frame.getContentPane().add(btnBackToMenu);
		
		JLabel lblCandidateList = new JLabel("Candidate List");
		lblCandidateList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidateList.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblCandidateList.setBounds(234, 21, 425, 48);
		frame.getContentPane().add(lblCandidateList);
	}

}
