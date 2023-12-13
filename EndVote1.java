import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class EndVote1 extends JFrame {
	private static int i = 5;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndVote1 frame = new EndVote1();
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
	public EndVote1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThisPageWill_1 = new JLabel("" + i);
		lblThisPageWill_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageWill_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThisPageWill_1.setBounds(422, 290, 46, 48);
		
		Timer timer = new Timer(1000, new ActionListener() {
            int count = i;

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                lblThisPageWill_1.setText("" + count);

                if (count == 0) {
                    ((Timer) e.getSource()).stop();
                    dispose();
					AltLogin1 altlog = new AltLogin1();
					altlog.setVisible(true);
                }
            }
        });

        timer.start();
        getContentPane().add(lblThisPageWill_1);
		
		JLabel lblThankYouFor = new JLabel("Thank you for voting!");
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThankYouFor.setBounds(260, 129, 378, 48);
		getContentPane().add(lblThankYouFor);
		
		JLabel lblThisPageWill = new JLabel("This page will close in:");
		lblThisPageWill.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageWill.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThisPageWill.setBounds(254, 236, 378, 48);
		getContentPane().add(lblThisPageWill);
	}

}
