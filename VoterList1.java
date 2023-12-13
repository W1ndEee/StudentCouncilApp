import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class VoterList1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterList1 frame = new VoterList1();
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
	public VoterList1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRemoveVoter = new JButton("Remove Voter");
		btnRemoveVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRemoveVoter.setBounds(569, 528, 171, 38);
		getContentPane().add(btnRemoveVoter);
		
		JButton btnAddVoter = new JButton("Add Voter");
		btnAddVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddVoter1 addvoter = new AddVoter1();
				addvoter.setVisible(true);
			}
		});
		btnAddVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddVoter.setBounds(296, 528, 171, 38);
		getContentPane().add(btnAddVoter);
		
		JButton btnSearchByStatus = new JButton("Search by status");
		btnSearchByStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByStatus.setBounds(16, 361, 171, 38);
		getContentPane().add(btnSearchByStatus);
		
		JButton btnSearchByYear = new JButton("Search by Year");
		btnSearchByYear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByYear.setBounds(16, 276, 171, 38);
		getContentPane().add(btnSearchByYear);
		
		JButton btnSearchByName = new JButton("Search by Name");
		btnSearchByName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearchByName.setBounds(16, 192, 171, 38);
		getContentPane().add(btnSearchByName);
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPage1 adminp = new AdminPage1();
				adminp.setVisible(true);
			}
		});
		btnBackToMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToMenu.setBounds(16, 21, 171, 38);
		getContentPane().add(btnBackToMenu);
		
		JLabel lblVoterList = new JLabel("Voter List");
		lblVoterList.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoterList.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblVoterList.setBounds(324, 18, 268, 48);
		getContentPane().add(lblVoterList);
	}

}
