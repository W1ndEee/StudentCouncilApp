import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CandidateList1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandidateList1 frame = new CandidateList1();
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
	public CandidateList1() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnAddremove = new JButton("Add/Remove");
		btnAddremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddCandidate1 addcan = new AddCandidate1();
				addcan.setVisible(true);
				
			}
		});
		btnAddremove.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddremove.setBounds(503, 488, 171, 38);
		getContentPane().add(btnAddremove);
		
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
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPage1 adminp = new AdminPage1();
				adminp.setVisible(true);
				
			}
		});
		btnBackToMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToMenu.setBounds(171, 488, 171, 38);
		getContentPane().add(btnBackToMenu);
		
		JLabel lblCandidateList = new JLabel("Candidate List");
		lblCandidateList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidateList.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblCandidateList.setBounds(234, 21, 425, 48);
		getContentPane().add(lblCandidateList);
		
		table = new JTable();
		
		table.setBounds(156, 83, 562, 374);
		contentPane.add(table);
	}
}
