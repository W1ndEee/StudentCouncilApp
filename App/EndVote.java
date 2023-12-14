package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EndVote {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndVote window = new EndVote();
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
	public EndVote() {
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
		
		JLabel lblThisPageWill_1 = new JLabel("5");
		lblThisPageWill_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageWill_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThisPageWill_1.setBounds(422, 290, 46, 48);
		frame.getContentPane().add(lblThisPageWill_1);
		
		JLabel lblThankYouFor = new JLabel("Thank you for voting!");
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThankYouFor.setBounds(260, 129, 378, 48);
		frame.getContentPane().add(lblThankYouFor);
		
		JLabel lblThisPageWill = new JLabel("This page will close in:");
		lblThisPageWill.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageWill.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThisPageWill.setBounds(254, 236, 378, 48);
		frame.getContentPane().add(lblThisPageWill);
	}

}
