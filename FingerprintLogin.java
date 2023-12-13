
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FingerprintLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FingerprintLogin window = new FingerprintLogin();
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
	public FingerprintLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(900, 600);
		
		JButton btnNewButton = new JButton("Alternate Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AltLogin1 altlog = new AltLogin1();
				altlog.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(345, 491, 179, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Hello, please scan your fingerprint to log in.\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(42, 131, 817, 98);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIfYouAre = new JLabel("If you are having trouble using the fingerprint scanner, \r\n");
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouAre.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblIfYouAre.setBounds(42, 353, 817, 122);
		frame.getContentPane().add(lblIfYouAre);
		
		JLabel lblpls = new JLabel("please click the button below:  \r\n");
		lblpls.setHorizontalAlignment(SwingConstants.CENTER);
		lblpls.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblpls.setBounds(42, 353, 817, 202);
		frame.getContentPane().add(lblpls);
	}
}

