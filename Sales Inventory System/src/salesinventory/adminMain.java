package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMain frame = new adminMain();
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
	public adminMain() {
		setTitle("Admin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 763);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(new Color(25, 25, 112));
		lblAdmin.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblAdmin.setBounds(284, 62, 485, 68);
		contentPane.add(lblAdmin);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to do ?");
		lblWhatDoYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatDoYou.setForeground(new Color(25, 25, 112));
		lblWhatDoYou.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblWhatDoYou.setBounds(311, 162, 449, 42);
		contentPane.add(lblWhatDoYou);
		
		JButton btnDeleteDetails = new JButton("Delete Details");
		btnDeleteDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDetails obj = new deleteDetails();
				obj.setVisible(true);
			}
		});
		btnDeleteDetails.setForeground(new Color(25, 25, 112));
		btnDeleteDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDeleteDetails.setBounds(388, 290, 269, 53);
		contentPane.add(btnDeleteDetails);
		
		JButton btnUpadteDetails = new JButton("Update Details");
		btnUpadteDetails.setForeground(new Color(25, 25, 112));
		btnUpadteDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnUpadteDetails.setBounds(388, 415, 269, 53);
		contentPane.add(btnUpadteDetails);
		
		JButton btnPrintDetails = new JButton("Show Details");
		btnPrintDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayWindow obj = new displayWindow();
				obj.setVisible(true);
			}
		});
		btnPrintDetails.setForeground(new Color(25, 25, 112));
		btnPrintDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnPrintDetails.setBounds(388, 539, 269, 53);
		contentPane.add(btnPrintDetails);
	}
}
