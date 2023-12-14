package App;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FingerprintLogin1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FingerprintLogin1 frame = new FingerprintLogin1();
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
	public FingerprintLogin1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnNewButton = new JButton("Alternate Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltLogin1 altlog = new AltLogin1();
				altlog.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(345, 491, 179, 38);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Hello, please scan your fingerprint to log in.\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(42, 131, 817, 98);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIfYouAre = new JLabel("If you are having trouble using the fingerprint scanner, \r\n");
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouAre.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblIfYouAre.setBounds(42, 353, 817, 122);
		getContentPane().add(lblIfYouAre);
		
		JLabel lblpls = new JLabel("please click the button below:  \r\n");
		lblpls.setHorizontalAlignment(SwingConstants.CENTER);
		lblpls.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblpls.setBounds(42, 353, 817, 202);
		getContentPane().add(lblpls);
	}

}
