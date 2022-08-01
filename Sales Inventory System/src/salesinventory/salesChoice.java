package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class salesChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesChoice frame = new salesChoice();
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
	public salesChoice() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 851, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalesRecords = new JLabel("Sales Records");
		lblSalesRecords.setForeground(new Color(25, 25, 112));
		lblSalesRecords.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblSalesRecords.setBounds(255, 64, 340, 53);
		contentPane.add(lblSalesRecords);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(25, 25, 112));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginForm ob = new LoginForm();
				ob.setVisible(true);
				
			}
		});
		btnLogin.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnLogin.setBounds(323, 409, 208, 53);
		contentPane.add(btnLogin);
		
		JButton btn2 = new JButton("Register");
		btn2.setForeground(new Color(25, 25, 112));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerationForm obj = new registerationForm();
				obj.setVisible(true);
			}
		});
		btn2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn2.setBounds(310, 239, 208, 53);
		contentPane.add(btn2);
		
		JLabel lblNewToThis = new JLabel("New to this application");
		lblNewToThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewToThis.setForeground(new Color(25, 25, 112));
		lblNewToThis.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblNewToThis.setBounds(197, 176, 449, 42);
		contentPane.add(lblNewToThis);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account");
		lblAlreadyHaveAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyHaveAn.setForeground(new Color(25, 25, 112));
		lblAlreadyHaveAn.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblAlreadyHaveAn.setBounds(197, 356, 449, 42);
		contentPane.add(lblAlreadyHaveAn);
	}

}
